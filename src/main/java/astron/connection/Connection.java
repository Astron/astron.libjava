package astron.connection;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import astron.datagram.Datagram;
import astron.datagram.DatagramIterator;

public abstract class Connection implements Runnable {

    private final String _address;
    private final int _port;
    private boolean _connected;

    private Socket _socket;
    private DataInputStream _inputStream;
    private DataOutputStream _outputStream;

    private boolean _polling;
    private Thread _thread;

    public Connection(final String address, final int port) {
        _address = address;
        _port = port;

        _connected = true;

        try {

            _socket = new Socket(_address, _port);

            _inputStream = new DataInputStream(_socket.getInputStream());
            _outputStream = new DataOutputStream(_socket.getOutputStream());

        } catch (UnknownHostException e) {
            
            handleUnknownHost(e);
            _connected = false;

        } catch (IOException e) {

            handleException(e);
            _connected = false;

        }
    }

    public void send(final Datagram datagram) {
        datagram.writeTo(_outputStream);
    }

    public void send(final byte[] bytes) {
        try {
            _outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleUnknownHost(final Exception e) {
        System.out.println(String.format("Unknown host: %s:%d", _address, _port));
    }

    public void handleException(final Exception e) {
        System.out.println(String.format("Got an unknown Exception: %s", e.toString()));
    }

    public boolean isConnected() {
        return _connected;
    }

    public String getAddress() {
        return _address;
    }

    public int getPort() {
        return _port;
    }

    public DataInputStream getInputStream() {
        return _inputStream;
    }

    public DataOutputStream getOutputStream() {
        return _outputStream;
    }

    public abstract void handleDatagram(final DatagramIterator datagram, final int messageType);

    public void startPolling() {
        if(_polling) return;
        _polling = true;
        _thread = new Thread(this);
        _thread.start();
    }

    public void stopPolling() {
        if(!_polling) return;
        _polling = false;
        try {
            _thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        for (;;) {

            try {

                // Get the lengthHeader of our datagram
                byte[] lengthHeader = new byte[2];
                _inputStream.readFully(lengthHeader);

                // Read the bytes
                ByteBuffer lengthBuffer = ByteBuffer.allocate(2);
                lengthBuffer.order(ByteOrder.LITTLE_ENDIAN);
                lengthBuffer.put(lengthHeader);
                int length = lengthBuffer.getChar(0);

                // Get the remaining data
                byte[] data = new byte[length];
                _inputStream.readFully(data);

                // Create a datagram
                DatagramIterator datagram = new DatagramIterator(data);

                // Get the message type
                int messageType = datagram.getUint16();

                // Handle the datagram
                handleDatagram(datagram, messageType);

            } catch (Exception e) {

                System.out.println(e.toString());

            }

        }
    }
}
