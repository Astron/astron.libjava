grammar DC;

// ------ Parsing Elements ------

// A DC File consists of zero or more statements
init : statement*
     ;

// Based on the reference bison parser, statements can be:
// - a dclass
// - a dstruct
// - an import statement
// - a typedef
// - a keyword declaration
statement : importDClass
          | importDClassNoFrom
          | keywordDef
          ;

// Imports
importDClassNoFrom : KW_IMPORT importModule ;

importDClass : KW_FROM importModule KW_IMPORT importSymbols ;

importModule : importAlternatives
             | importModule '.' importAlternatives
             ;

importAlternatives : IDENTIFIER
                   | importAlternatives '/' IDENTIFIER
                   ;

importSymbols : importSymbolList
              | '*'
              ;

importSymbolList : importAlternatives
                 | importSymbolList ',' importAlternatives
                 ;

// Defining a custom keyword
keywordDef : KW_KEYWORD IDENTIFIER ';' ;

// ------ Lexical Elements ------

KW_DCLASS : 'dclass' ;
KW_STRUCT : 'struct' ;
KW_FROM : 'from' ;
KW_IMPORT : 'import' ;
KW_TYPEDEF : 'typedef' ;
KW_KEYWORD : 'keyword' ;

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

// See https://github.com/antlr/grammars-v4/blob/master/c/C.g4#L886-L894
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

IDENTIFIER : [A-Za-z_][A-Za-z_0-9]+ ;

// Disregard  spaces, tabs, returns, and new lines
WS : [ \t\r\n]+ -> skip ;
