package com.banana.reader

import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable

class Item() : Parcelable {
    var id = 0
    var name = ""

    private val mDeathRecipient: IBinder.DeathRecipient = IBinder.DeathRecipient {
        TODO()
    }

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString().toString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeInt(id)
        p0.writeString(name)
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}