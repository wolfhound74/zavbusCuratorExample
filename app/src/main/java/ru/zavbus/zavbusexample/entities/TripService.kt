package ru.zavbus.zavbusexample.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "trip_services",
        foreignKeys = arrayOf(ForeignKey(entity = TripPacket::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("tripPacketId"),
                onDelete = ForeignKey.CASCADE)
        ))
data class TripService(
        @PrimaryKey(autoGenerate = true) val id: Long,
        @ColumnInfo(name = "tripPacketId") val tripPacketId: Long,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "rent") val rent: Boolean,
        @ColumnInfo(name = "price") val price: Long
) : java.io.Serializable {
    override fun toString(): String {
        return name
    }
}