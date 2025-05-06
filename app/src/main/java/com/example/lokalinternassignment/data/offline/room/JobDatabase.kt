package com.example.lokalinternassignment.data.offline.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( entities = [EachJob::class], version = 1)
abstract class JobDatabase: RoomDatabase() {
    abstract fun eachJobDao(): EachJobDao
}