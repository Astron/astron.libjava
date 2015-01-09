grammar DC;

// ------ Parsing Elements ------

import_dclass : KW_IMPORT import_module
              | KW_FROM import_module KW_IMPORT import_symbols
              ;

import_module : import_alternatives
              | import_module '.' import_alternatives
              ;

import_symbols : import_symbol_list
               | '*'
               ;

import_symbol_list : import_alternatives
                   | import_symbol_list ',' import_alternatives
                   ;

import_alternatives : IDENTIFIER
                    | import_alternatives '/' IDENTIFIER
                    ;

// ------ Lexical Elements ------

KW_DCLASS : 'dclass' ;
KW_STRUCT : 'struct' ;
KW_FROM : 'from' ;
KW_IMPORT : 'import' ;
KW_TYPEDEF : 'typedef' ;

KW_STRING : 'string' ;
KW_BLOB : 'blob' ;
KW_INT8 : 'int8' ;
KW_INT16 : 'int16' ;
KW_INT32 : 'int32' ;
KW_INT64 : 'int64' ;
KW_UINT8 : 'uint8' ;
KW_UINT16 : 'uint16' ;
KW_UINT32 : 'uint32' ;
KW_UINT64 : 'uint64' ;
KW_FLOAT32 : 'float32' ;
KW_FLOAT64 : 'float64' ;

// see https://github.com/antlr/grammars-v4/blob/master/c/C.g4#L886-L894
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;

IDENTIFIER : [A-Za-z_][A-Za-z_0-9]+ ;

// Disregard  spaces, tabs, returns, and new lines
WS : [ \t\r\n]+ -> skip ;
