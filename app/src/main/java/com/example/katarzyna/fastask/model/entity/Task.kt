package com.example.katarzyna.fastask.model.entity

import android.os.Parcel
import android.os.Parcelable


data class Task(val id: Int,
                val action: String,
                val location: String,
                val creatorId: Int,
                val active: Boolean,
                val comment: String, //todo date to date-format
                val reservingId: Int,
                val data: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            !parcel.readByte().equals(0),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(action)
        parcel.writeString(location)
        parcel.writeInt(creatorId)
        parcel.writeByte((if (active) 1 else 0).toByte())
        parcel.writeString(comment)
        parcel.writeInt(reservingId)
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