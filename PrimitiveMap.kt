/*Copyright (c) 2021 Jeziel Lago

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
*/
package dev.jeziellago.primitivemap


interface PrimitiveMap {
    fun putNumber(key: String, value: Number): PrimitiveMap
    fun putString(key: String, value: String): PrimitiveMap
    fun putMap(key: String, value: PrimitiveMap): PrimitiveMap
    fun entries(): MutableSet<MutableMap.MutableEntry<String, Any>>
    fun containsKey(key: String): Boolean
    fun getString(key: String, default: String): String
    fun getNumber(key: String, default: Number): Number
    val size: Int
    operator fun get(key: String): Any?
    fun toMap(): Map<String, Any>
}

fun primitiveMap(): PrimitiveMap {
    return object : PrimitiveMap {
        val internalMap = mutableMapOf<String, Any>()
        override fun putNumber(key: String, value: Number) = apply {
            internalMap[key] = value
        }

        override fun putString(key: String, value: String) = apply {
            internalMap[key] = value
        }

        override fun putMap(key: String, value: PrimitiveMap) = apply {
            internalMap[key] = value
        }

        override fun entries(): MutableSet<MutableMap.MutableEntry<String, Any>> {
            return internalMap.entries
        }

        override fun containsKey(key: String): Boolean {
            return internalMap.containsKey(key)
        }

        override fun getString(key: String, default: String): String {
            return internalMap[key] as? String ?: default
        }

        override fun getNumber(key: String, default: Number): Number {
            return internalMap[key] as? Number ?: default
        }

        override val size: Int
            get() = internalMap.size

        override fun get(key: String): Any? {
            return internalMap[key]
        }

        override fun toMap(): Map<String, Any> {
            val entries = internalMap.map { (key, value) ->
                if (value is PrimitiveMap) key to value.toMap()
                else key to value
            }
            return mapOf(*entries.toTypedArray())
        }
    }
}

