package com.example.lokalinternassignment.domain.interfaces

import com.example.lokalinternassignment.domain.constant.endpoint
import com.example.lokalinternassignment.domain.models.apiModels.Results
import com.example.lokalinternassignment.domain.models.retrofitTransactionModels.RetrofitResult
import retrofit2.http.GET

interface RetrofitRepository {
    @GET(endpoint)
    suspend fun getData (): RetrofitResult<Results>
}