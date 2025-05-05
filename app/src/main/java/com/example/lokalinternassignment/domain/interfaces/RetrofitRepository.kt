package com.example.lokalinternassignment.domain.interfaces

import com.example.lokalinternassignment.domain.constants.endpoint
import com.example.lokalinternassignment.domain.models.Results
import retrofit2.http.GET

interface RetrofitRepository {

    @GET(endpoint)
    suspend fun getData (): Results
}