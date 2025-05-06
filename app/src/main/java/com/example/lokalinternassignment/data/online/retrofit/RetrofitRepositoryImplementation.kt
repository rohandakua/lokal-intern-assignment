package com.example.lokalinternassignment.data.online.retrofit

import android.util.Log
import com.example.lokalinternassignment.domain.interfaces.RetrofitRepository
import com.example.lokalinternassignment.domain.models.apiModels.Results
import com.example.lokalinternassignment.domain.models.retrofitTransactionModels.RetrofitResult

class RetrofitRepositoryImplementation(
    private val api: RetrofitRepository
) {
    private val TAG = "RetrofitRepositoryImplementation"
    suspend fun getJobs(pageNo : Int): RetrofitResult<Results>{
        return try {
            val result = api.getData(pageNo)
            Log.e(TAG, "getJobs: result fetched succesfully")
            RetrofitResult.Success(result)
        }catch (e : Exception){
            Log.e(TAG, "getJobs error: ${e.message}")
            RetrofitResult.Error(e.message ?: "Unknown error")
        }
    }
}