package com.example.lokalinternassignment.domain.interfaces

import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult

interface RoomRepository {

    suspend fun getAllJobs(): RoomResult<List<EachJob>>
    suspend fun saveJob (job : EachJob) : RoomResult<Unit>
}