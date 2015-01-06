package astron.connection;

/**
 * Constants for Astron message types and other magic numbers
 *
 * See: https://github.com/Astron/Astron/blob/master/src/core/msgtypes.h
 * See: https://github.com/Astron/Astron/blob/master/src/clientagent/ClientMessages.h
 */
public class MessageTypes {

    // Defined context values
    public static final int STATESERVER_CONTEXT_WAKE_CHILDREN = 1001;

    // Reserved
    public static final int RESERVED_MSG_TYPE = 0;

    // Control messages
    public static final int CONTROL_ADD_CHANNEL        = 9000;
    public static final int CONTROL_REMOVE_CHANNEL     = 9001;
    public static final int CONTROL_ADD_RANGE          = 9002;
    public static final int CONTROL_REMOVE_RANGE       = 9003;
    public static final int CONTROL_ADD_POST_REMOVE    = 9010;
    public static final int CONTROL_CLEAR_POST_REMOVES = 9011;
    public static final int CONTROL_SET_CON_NAME       = 9012;
    public static final int CONTROL_SET_CON_URL        = 9013;
    public static final int CONTROL_LOG_MESSAGE        = 9014;

    // ClientAgent messages
    public static final int CLIENTAGENT_SET_STATE             = 1000;
    public static final int CLIENTAGENT_SET_CLIENT_ID         = 1001;
    public static final int CLIENTAGENT_SEND_DATAGRAM         = 1002;
    public static final int CLIENTAGENT_EJECT                 = 1004;
    public static final int CLIENTAGENT_DROP                  = 1005;
    public static final int CLIENTAGENT_DECLARE_OBJECT        = 1010;
    public static final int CLIENTAGENT_UNDECLARE_OBJECT      = 1011;
    public static final int CLIENTAGENT_ADD_SESSION_OBJECT    = 1012;
    public static final int CLIENTAGENT_REMOVE_SESSION_OBJECT = 1013;
    public static final int CLIENTAGENT_SET_FIELDS_SENDABLE   = 1014;
    public static final int CLIENTAGENT_OPEN_CHANNEL          = 1100;
    public static final int CLIENTAGENT_CLOSE_CHANNEL         = 1101;
    public static final int CLIENTAGENT_ADD_POST_REMOVE       = 1110;
    public static final int CLIENTAGENT_CLEAR_POST_REMOVES    = 1111;
    public static final int CLIENTAGENT_ADD_INTEREST          = 1200;
    public static final int CLIENTAGENT_ADD_INTEREST_MULTIPLE = 1201;
    public static final int CLIENTAGENT_REMOVE_INTEREST       = 1203;
    public static final int CLIENTAGENT_DONE_INTEREST_RESP    = 1204;

    // StateServer control messages
    public static final int STATESERVER_CREATE_OBJECT_WITH_REQUIRED       = 2000;
    public static final int STATESERVER_CREATE_OBJECT_WITH_REQUIRED_OTHER = 2001;
    public static final int STATESERVER_DELETE_AI_OBJECTS                 = 2009;
    // StateServer object messages
    public static final int STATESERVER_OBJECT_GET_FIELD         = 2010;
    public static final int STATESERVER_OBJECT_GET_FIELD_RESP    = 2011;
    public static final int STATESERVER_OBJECT_GET_FIELDS        = 2012;
    public static final int STATESERVER_OBJECT_GET_FIELDS_RESP   = 2013;
    public static final int STATESERVER_OBJECT_GET_ALL           = 2014;
    public static final int STATESERVER_OBJECT_GET_ALL_RESP      = 2015;
    public static final int STATESERVER_OBJECT_SET_FIELD         = 2020;
    public static final int STATESERVER_OBJECT_SET_FIELDS        = 2021;
    public static final int STATESERVER_OBJECT_DELETE_FIELD_RAM  = 2030;
    public static final int STATESERVER_OBJECT_DELETE_FIELDS_RAM = 2031;
    public static final int STATESERVER_OBJECT_DELETE_RAM        = 2032;
    // StateServer visibility messages
    public static final int STATESERVER_OBJECT_SET_LOCATION                       = 2040;
    public static final int STATESERVER_OBJECT_CHANGING_LOCATION                  = 2041;
    public static final int STATESERVER_OBJECT_ENTER_LOCATION_WITH_REQUIRED       = 2042;
    public static final int STATESERVER_OBJECT_ENTER_LOCATION_WITH_REQUIRED_OTHER = 2043;
    public static final int STATESERVER_OBJECT_GET_LOCATION                       = 2044;
    public static final int STATESERVER_OBJECT_GET_LOCATION_RESP                  = 2045;
    public static final int STATESERVER_OBJECT_SET_AI                             = 2050;
    public static final int STATESERVER_OBJECT_CHANGING_AI                        = 2051;
    public static final int STATESERVER_OBJECT_ENTER_AI_WITH_REQUIRED             = 2052;
    public static final int STATESERVER_OBJECT_ENTER_AI_WITH_REQUIRED_OTHER       = 2053;
    public static final int STATESERVER_OBJECT_GET_AI                             = 2054;
    public static final int STATESERVER_OBJECT_GET_AI_RESP                        = 2055;
    public static final int STATESERVER_OBJECT_SET_OWNER                          = 2060;
    public static final int STATESERVER_OBJECT_CHANGING_OWNER                     = 2061;
    public static final int STATESERVER_OBJECT_ENTER_OWNER_WITH_REQUIRED          = 2062;
    public static final int STATESERVER_OBJECT_ENTER_OWNER_WITH_REQUIRED_OTHER    = 2063;
    public static final int STATESERVER_OBJECT_GET_OWNER                          = 2064;
    public static final int STATESERVER_OBJECT_GET_OWNER_RESP                     = 2065;
    public static final int STATESERVER_OBJECT_ENTER_INTEREST_WITH_REQUIRED       = 2066;
    public static final int STATESERVER_OBJECT_ENTER_INTEREST_WITH_REQUIRED_OTHER = 2067;
    // StateServer parent-method messages
    public static final int STATESERVER_OBJECT_GET_ZONE_OBJECTS     = 2100;
    public static final int STATESERVER_OBJECT_GET_ZONES_OBJECTS    = 2102;
    public static final int STATESERVER_OBJECT_GET_CHILDREN         = 2104;
    public static final int STATESERVER_OBJECT_GET_ZONE_COUNT       = 2110;
    public static final int STATESERVER_OBJECT_GET_ZONE_COUNT_RESP  = 2111;
    public static final int STATESERVER_OBJECT_GET_ZONES_COUNT      = 2112;
    public static final int STATESERVER_OBJECT_GET_ZONES_COUNT_RESP = 2113;
    public static final int STATESERVER_OBJECT_GET_CHILD_COUNT      = 2114;
    public static final int STATESERVER_OBJECT_GET_CHILD_COUNT_RESP = 2115;
    public static final int STATESERVER_OBJECT_DELETE_ZONE          = 2120;
    public static final int STATESERVER_OBJECT_DELETE_ZONES         = 2122;
    public static final int STATESERVER_OBJECT_DELETE_CHILDREN      = 2124;
    public static final int STATESERVER_GET_ACTIVE_ZONES            = 2125;
    public static final int STATESERVER_GET_ACTIVE_ZONES_RESP       = 2126;

    // DBSS object messages
    public static final int DBSS_OBJECT_ACTIVATE_WITH_DEFAULTS       = 2200;
    public static final int DBSS_OBJECT_ACTIVATE_WITH_DEFAULTS_OTHER = 2201;
    public static final int DBSS_OBJECT_GET_ACTIVATED                = 2207;
    public static final int DBSS_OBJECT_GET_ACTIVATED_RESP           = 2208;
    public static final int DBSS_OBJECT_DELETE_FIELD_RAM             = 2230;
    public static final int DBSS_OBJECT_DELETE_FIELDS_RAM            = 2231;
    public static final int DBSS_OBJECT_DELETE_DISK                  = 2232;

    // DatabaseServer messages
    public static final int DBSERVER_CREATE_OBJECT                    = 3000;
    public static final int DBSERVER_CREATE_OBJECT_RESP               = 3001;
    public static final int DBSERVER_OBJECT_GET_FIELD                 = 3010;
    public static final int DBSERVER_OBJECT_GET_FIELD_RESP            = 3011;
    public static final int DBSERVER_OBJECT_GET_FIELDS                = 3012;
    public static final int DBSERVER_OBJECT_GET_FIELDS_RESP           = 3013;
    public static final int DBSERVER_OBJECT_GET_ALL                   = 3014;
    public static final int DBSERVER_OBJECT_GET_ALL_RESP              = 3015;
    public static final int DBSERVER_OBJECT_SET_FIELD                 = 3020;
    public static final int DBSERVER_OBJECT_SET_FIELDS                = 3021;
    public static final int DBSERVER_OBJECT_SET_FIELD_IF_EQUALS       = 3022;
    public static final int DBSERVER_OBJECT_SET_FIELD_IF_EQUALS_RESP  = 3023;
    public static final int DBSERVER_OBJECT_SET_FIELDS_IF_EQUALS      = 3024;
    public static final int DBSERVER_OBJECT_SET_FIELDS_IF_EQUALS_RESP = 3025;
    public static final int DBSERVER_OBJECT_SET_FIELD_IF_EMPTY        = 3026;
    public static final int DBSERVER_OBJECT_SET_FIELD_IF_EMPTY_RESP   = 3027;
    public static final int DBSERVER_OBJECT_DELETE_FIELD              = 3030;
    public static final int DBSERVER_OBJECT_DELETE_FIELDS             = 3031;
    public static final int DBSERVER_OBJECT_DELETE                    = 3032;

    public static final int CLIENT_HELLO                             = 1;
    public static final int CLIENT_HELLO_RESP                        = 2;
    public static final int CLIENT_DISCONNECT                        = 3;
    public static final int CLIENT_EJECT                             = 4;
    public static final int CLIENT_HEARTBEAT                         = 5;
    public static final int CLIENT_OBJECT_SET_FIELD                  = 120;
    public static final int CLIENT_OBJECT_SET_FIELDS                 = 121;
    public static final int CLIENT_OBJECT_LEAVING                    = 132;
    public static final int CLIENT_OBJECT_LEAVING_OWNER              = 161;
    public static final int CLIENT_OBJECT_LOCATION                   = 140;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED             = 142;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED_OTHER       = 143;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED_OWNER       = 172;
    public static final int CLIENT_ENTER_OBJECT_REQUIRED_OTHER_OWNER = 173;
    public static final int CLIENT_DONE_INTEREST_RESP                = 204;
    public static final int CLIENT_ADD_INTEREST                      = 200;
    public static final int CLIENT_ADD_INTEREST_MULTIPLE             = 201;
    public static final int CLIENT_REMOVE_INTEREST                   = 203;

    public static final int CLIENT_DISCONNECT_GENERIC                = 1;
    public static final int CLIENT_DISCONNECT_OVERSIZED_DATAGRAM     = 106;
    public static final int CLIENT_DISCONNECT_NO_HELLO               = 107;
    public static final int CLIENT_DISCONNECT_INVALID_MSGTYPE        = 108;
    public static final int CLIENT_DISCONNECT_TRUNCATED_DATAGRAM     = 109;
    public static final int CLIENT_DISCONNECT_ANONYMOUS_VIOLATION    = 113;
    public static final int CLIENT_DISCONNECT_FORBIDDEN_INTEREST     = 115;
    public static final int CLIENT_DISCONNECT_MISSING_OBJECT         = 117;
    public static final int CLIENT_DISCONNECT_FORBIDDEN_FIELD        = 118;
    public static final int CLIENT_DISCONNECT_FORBIDDEN_RELOCATE     = 119;
    public static final int CLIENT_DISCONNECT_BAD_VERSION            = 124;
    public static final int CLIENT_DISCONNECT_BAD_DCHASH             = 125;
    public static final int CLIENT_DISCONNECT_SESSION_OBJECT_DELETED = 153;
    
}
