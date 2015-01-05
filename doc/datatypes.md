Astron Data Types in Java
-------------------------

Below is a table of how Astron datatypes are unpacked from the wire in Java.

| Astron Data Type | Java Data Type |
|------------------|----------------|
| `int8` | `byte` |
| `int16` | `short` |
| `int32` | `int` |
| `int64` | `long` |
| `uint8` | `short` |
| `uint16` | `int` |
| `uint32` | `long` |
| `uint64` | `long` |

Because Java doesn't have unsigned types, Astron will unpack unsigned itegral types as Java integral types of twice the width (when possible). This allows reasonable integer manipulation, up until the `uint64`. Unfortunately, uint64s must be marshalled into Java's 64-bit wide signed `long` type. As a result, numbers formatted as negative by Java can be interpreted and accepted by Astron. There are plans for Astron to provide uint64 helper classes for tasks like channel subscription that should simplify the process.

