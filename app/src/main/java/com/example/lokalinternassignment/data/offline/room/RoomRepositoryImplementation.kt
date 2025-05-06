package com.example.lokalinternassignment.data.offline.room

import android.util.Log
import com.example.lokalinternassignment.domain.interfaces.RoomRepository
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult
import kotlinx.coroutines.CoroutineScope
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
                Log.d(TAG, "getAllJobs: $jobs")
                RoomResult.Success(jobs)
            }catch (e : CancellationException){
                Log.e(TAG, "getAllJobs: Cancelled")
                RoomResult.Cancelled("Cancelled")
            }catch (e : Exception){
                Log.e(TAG, "getAllJobs error: ${e.message}")
                RoomResult.Error(e.message ?: "Unknown error")
            }
        }

    }

    override suspend fun saveJob(job: EachJob): RoomResult<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                dao.insertJob(job)
                Log.e(TAG, "saveJob: Saved")
                RoomResult.Success(Unit)
            } catch (e: CancellationException) {
                Log.e(TAG , "saveJob: Cancelled")
                RoomResult.Cancelled("Cancelled")
            } catch (e: Exception) {
                Log.e(TAG, "saveJob error: ${e.message}")
                RoomResult.Error(e.message ?: "Unknown error")
            }
        }
    }

    override suspend fun deleteJob(jobId: Int): RoomResult<Unit> {
        return withContext(Dispatchers.IO){
            try{
                dao.deleteJobById(jobId)
                Log.e(TAG, "deleteJob: Deleted")
                RoomResult.Success(Unit)
            }catch (e: CancellationException) {
                Log.e(TAG , "deleteJob: Cancelled")
                RoomResult.Cancelled("Cancelled")
            } catch (e: Exception) {
                Log.e(TAG, "deleteJob error: ${e.message}")
                RoomResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}