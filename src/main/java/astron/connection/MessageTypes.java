package main.java.astron.connection;

public class MessageTypes {

    public static final int CLIENT_HELLO = 1;
    public static final int CLIENT_HELLO_RESP = 2;
    public static final int CLIENT_DISCONNECT = 3;
    public static final int CLIENT_EJECT = 4;
    public static final int CLIENT_HEARTBEAT = 5;
    public static final int CLIENT_OBJECT_SET_FIELD = 120;
    public static final int CLIENT_OBJECT_SET_FIELDS = 121;
    public static final int CLIENT_OBJECT_LEAVING = 132;
    public static final int CLIENT_OBJECT_LEAVING_OWNER = 161;
    public static final int CLIENT_OBJECT_LOCATION = 140;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED = 142;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED_OTHER = 143;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED_OWNER = 172;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED_OTHER_OWNER = 173;
    public static final int CLIENT_DONE_INTEREST_RESP = 204;
    public static final int CLIENT_ADD_INTEREST = 200;
    public static final int CLIENT_ADD_INTEREST_MULTIPLE = 201;
    public static final int CLIENT_REMOVE_INTEREST = 203;

    public static final int CLIENT_DISCONNECT_GENERIC = 1;
    public static final int CLIENT_DISCONNECT_OVERSIZED_DATAGRAM = 106;
    public static final int CLIENT_DISCONNECT_NO_HELLO = 107;
    public static final int CLIENT_DISCONNECT_INVALID_MSGTYPE = 108;
    public static final int CLIENT_DISCONNECT_TRUNCATED_DATAGRAM = 109;
    public static final int CLIENT_DISCONNECT_ANONYMOUS_VIOLATION = 113;
    public static final int CLIENT_DISCONNECT_FORBIDDEN_INTEREST = 115;
    public static final int CLIENT_DISCONNECT_MISSING_OBJECT = 117;
    public static final int CLIENT_DISCONNECT_FORBIDDEN_FIELD = 118;
    public static final int CLIENT_DISCONNECT_FORBIDDEN_RELOCATE = 119;
    public static final int CLIENT_DISCONNECT_BAD_VERSION = 124;
    public static final int CLIENT_DISCONNECT_BAD_DCHASH = 125;
    public static final int CLIENT_DISCONNECT_SESSION_OBJECT_DELETED = 153;
    
}
