package com.example.lokalinternassignment.data.offline.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EachJobDao {
    @Query("SELECT * FROM each_job")
    suspend fun getAllJobs(): List<EachJob>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob(job: EachJob)

    @Query("SELECT * FROM each_job WHERE jid = :jid")
    suspend fun getJobById(jid: Int): EachJob?



}