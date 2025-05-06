package com.example.lokalinternassignment.domain.interfaces


import com.example.lokalinternassignment.domain.models.apiModels.Results
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRepository {
    @GET("common/jobs")
    suspend fun getData(@Query("page") page: Int): Results
}
