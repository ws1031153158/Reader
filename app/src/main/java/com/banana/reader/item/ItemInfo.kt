package com.banana.reader.item

import android.os.Parcel
import android.os.Parcelable

class ItemInfo() : Parcelable {
    var itemId = 0
    var itemTitle = ""
    var itemIcon: ItemImageView? = null

    constructor(parcel: Parcel) : this() {
        itemId = parcel.readInt()
        itemTitle = parcel.readString().toString()
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(out: Parcel, flag: Int) {
        with(out) {
            writeInt(itemId)
            writeString(itemTitle)
        }
    }

    companion object CREATOR : Parcelable.Creator<ItemInfo> {
        override fun createFromParcel(input: Parcel): ItemInfo {
            return ItemInfo(input)
        }

        override fun newArray(size: Int): Array<ItemInfo?> {
            return arrayOfNulls(size)
        }
    }

}