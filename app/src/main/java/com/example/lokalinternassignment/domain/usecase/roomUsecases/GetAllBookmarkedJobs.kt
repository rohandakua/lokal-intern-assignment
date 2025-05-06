package com.example.lokalinternassignment.domain.usecase.roomUsecases

import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.data.offline.room.RoomRepositoryImplementation
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult

class GetAllBookmarkedJobs(
    private val repository: RoomRepositoryImplementation
) {
    suspend fun execute(): RoomResult<List<EachJob>> {
        return repository.getAllJobs()
    }
}