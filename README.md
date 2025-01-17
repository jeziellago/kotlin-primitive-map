
# Kotlin Primitive Map
Simple solution to create `Map`'s of primitive values in kotlin.
## How it works?
```kotlin
val myMap = primitiveMap()
    .putNumber("number", 1.333) // kotlin.Number
    .putString("name", "Jeziel") // kotlin.String
    .putMap("info", userInfo()) // PrimitiveMap
 ```
## Android Parcelable
You can use `PrimitiveMapParcelable` to put `PrimitiveMap` into `Bundle`.
```kotlin
val myMap = primitiveMap()
    .putNumber("number", 1.333)
    .putString("name", "Jeziel")

val parcelableMap = PrimitiveMapParcelable(myMap)

val bundle = Bundle().apply {
    putParcelable("primitive-map-key", parcelableMap) // put as parcelable
}
```
## Serialization and Json
Call `.toMap()` to convert from `PrimitiveMap` to `kotlin.collections.Map` and do serialization normally.
## Licence
```
Copyright (c) 2021 Jeziel Lago

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```