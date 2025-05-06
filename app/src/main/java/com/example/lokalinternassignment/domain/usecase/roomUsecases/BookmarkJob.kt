package com.example.lokalinternassignment.domain.usecase.roomUsecases
import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.data.offline.room.RoomRepositoryImplementation
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult

class BookmarkJob(
    private val repository: RoomRepositoryImplementation
) {
    /**
     * convert the api model of job to a new item of EachJob and save it in the database
     */
    suspend fun execute(job : EachJob): RoomResult<Unit> {
        return repository.saveJob(job)
    }
}