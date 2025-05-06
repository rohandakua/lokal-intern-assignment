package com.example.lokalinternassignment.data.offline.room

import com.example.lokalinternassignment.domain.interfaces.RoomRepository
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class RoomRepositoryImplementation(
    private val dao : EachJobDao
) : RoomRepository{
    private val TAG = "RoomRepositoyImplementation"

    override suspend fun getAllJobs(): RoomResult<List<EachJob>> {
        return withContext(Dispatchers.IO){
            try {
                val jobs = dao.getAllJobs()
                RoomResult.Success(jobs)
            }catch (e : CancellationException){
                RoomResult.Cancelled("Cancelled")
            }catch (e : Exception){
                RoomResult.Error(e.message ?: "Unknown error")
            }
        }

    }

    override suspend fun saveJob(job: EachJob): RoomResult<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                dao.insertJob(job)
                RoomResult.Success(Unit)
            } catch (e: CancellationException) {
                RoomResult.Cancelled("Cancelled")
            } catch (e: Exception) {
                RoomResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}