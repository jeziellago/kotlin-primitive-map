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

import android.os.Parcel
import android.os.Parcelable

data class PrimitiveMapParcelable(
    val map: PrimitiveMap
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(PrimitiveMap::class.java.classLoader) as PrimitiveMap
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(map)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<PrimitiveMapParcelable> {
        override fun createFromParcel(parcel: Parcel): PrimitiveMapParcelable {
            return PrimitiveMapParcelable(parcel)
        }

        override fun newArray(size: Int): Array<PrimitiveMapParcelable?> {
            return arrayOfNulls(size)
        }
    }
}