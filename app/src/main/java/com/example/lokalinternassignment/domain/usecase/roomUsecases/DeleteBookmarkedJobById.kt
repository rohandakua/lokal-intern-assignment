package com.example.lokalinternassignment.domain.usecase.roomUsecases

import com.example.lokalinternassignment.data.offline.room.RoomRepositoryImplementation
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult

class DeleteBookmarkedJobById(
    private val repository: RoomRepositoryImplementation
) {
    suspend fun execute(jobId : Int): RoomResult<Unit> {
        return repository.deleteJob(jobId)
    }
}