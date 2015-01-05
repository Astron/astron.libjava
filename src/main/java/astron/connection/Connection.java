package main.java.astron.connection;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import main.java.astron.datagram.Datagram;
import main.java.astron.datagram.DatagramIterator;

public abstract class Connection implements Runnable {

    private final String address;
    private final int port;
    private boolean connected;

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private boolean polling;
    private Thread thread;

    public Connection(String address, int port) {
        this.address = address;
        this.port = port;

        this.connected = true;

        try {

            this.socket = new Socket(this.address, this.port);

            this.inputStream = new DataInputStream(this.socket.getInputStream());
            this.outputStream = new DataOutputStream(this.socket.getOutputStream());

        } catch (UnknownHostException e) {

            this.handleUnknownHost(e);
            this.connected = false;

        } catch (IOException e) {

            this.handleException(e);
            this.connected = false;

        }
    }

    public void send(Datagram datagram) {
        datagram.writeTo(this.getOutputStream());
    }

    public void send(byte[] bytes) {
        try {
            this.outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleUnknownHost(Exception e) {
        System.out.println(String.format("Unknown host: %s:%d", this.address, this.port));
    }

    public void handleException(Exception e) {
        System.out.println(String.format("Got an unknown Exception: %s", e.toString()));
    }

    public boolean isConnected() {
        return this.connected;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    public DataInputStream getInputStream() {
        return this.inputStream;
    }

    public DataOutputStream getOutputStream() {
        return this.outputStream;
    }

    public abstract void handleDatagram(DatagramIterator datagram, int messageType);

    public void startPolling() {
        if(this.polling) return;
        this.polling = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void stopPolling() {
        if(!this.polling) return;
        this.polling = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        for (;;) {

            try {

                // Get the lengthHeader of our datagram
                byte[] lengthHeader = new byte[2];
                this.inputStream.readFully(lengthHeader);

                // Read the bytes
                ByteBuffer lengthBuffer = ByteBuffer.allocate(2);
                lengthBuffer.order(ByteOrder.LITTLE_ENDIAN);
                lengthBuffer.put(lengthHeader);
                int length = lengthBuffer.getChar(0);

                // Get the remaining data
                byte[] data = new byte[length];
                this.inputStream.readFully(data);

                // Create a datagram
                DatagramIterator datagram = new DatagramIterator(data);

                // Get the message type
                int messageType = datagram.getUint16();

                // Handle the datagram
                this.handleDatagram(datagram, messageType);

            } catch (Exception e) { System.out.println(e.toString()); }

        }
    }
}
