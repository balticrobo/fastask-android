package com.example.katarzyna.fastask.model

import android.os.Parcel
import android.os.Parcelable


data class Task(val id: Int,
                val action: String,
                val location: String,
                val creatorid: String,
                val active: Boolean,
                val comment: String,
                val data: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            !parcel.readByte().equals(0),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(action)
        parcel.writeString(location)
        parcel.writeString(creatorid)
        parcel.writeByte((if (active) 1 else 0).toByte())
        parcel.writeString(comment)
        parcel.writeString(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun createFromParcel(parcel: Parcel): Task {
            return Task(parcel)
        }

        override fun newArray(size: Int): Array<Task?> {
            return arrayOfNulls(size)
        }
    }
}


//data class Task(val id: Int,
//                val action: String,
//                val location: String,
//                val creatorid: String,
//                val active: Boolean,
//                val comment: String,
//                val data: String): Parcelable{
//
//    constructor(parcel: Parcel):this(
//        parcel.readString(),
//        parcel.readInt()
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Task> {
//        override fun createFromParcel(parcel: Parcel): Task {
//            return Task(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Task?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
