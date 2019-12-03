package ru.zavbus.zavbusexample.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import ru.zavbus.zavbusexample.entities.TripRecord

@Dao
interface TripRecordDao {

    @Query("SELECT * from trip_records")
    fun getAll(): List<TripRecord>

    @Query("SELECT * from trip_records WHERE tripId = :tripId AND confirmed = 1")
    fun getAllConfirmedRecords(tripId: Long): Array<TripRecord>

    @Query("SELECT * from trip_records WHERE tripId = :tripId")
    fun getAllRecords(tripId: Long): Array<TripRecord>

    @Query("SELECT sum(paidSumInBus) from trip_records WHERE tripId = :tripId AND confirmed = 1")
    fun getAllPaidSumInBus(tripId: Long): Int

    @Insert(onConflict = REPLACE)
    fun insert(record: TripRecord)

    @Update
    fun update(record: TripRecord)

    @Query("DELETE from trip_records")
    fun deleteAll()

    @Query("SELECT * FROM trip_records WHERE tripId = :tripId ORDER BY name")
    fun getRecordsByTrip(tripId: Long): Array<TripRecord>
}