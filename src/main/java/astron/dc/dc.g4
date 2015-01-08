grammar dc;

// ------ Lexical Elements ------

// Keywords

keyword : 'dclass'
        | 'struct'
        | 'typedef'
        ;

// Data Types

dataType : charType
         | intType
         | floatType
         | sizedType
         ;

fragment charType : 'char'
                  ;

fragment intType : 'int8'
                 | 'int16'
                 | 'int32'
                 | 'int64'
                 | 'uint8'
                 | 'uint16'
                 | 'uint32'
                 | 'uint64'
                 ;

fragment floatType : 'float64'
                   ;

fragment sizedType : 'string'
                   | 'blob'
                   ;
