package com.example.lokalinternassignment.domain.usecase.retrofitUsecases

import com.example.lokalinternassignment.data.online.retrofit.RetrofitRepositoryImplementation
import com.example.lokalinternassignment.domain.interfaces.RetrofitRepository
import com.example.lokalinternassignment.domain.models.apiModels.Results
import com.example.lokalinternassignment.domain.models.retrofitTransactionModels.RetrofitResult

class GetJobUsecase(
    private val repository: RetrofitRepositoryImplementation
) {
    suspend fun execute(page : Int): RetrofitResult<Results> {
        return repository.getJobs(page)
    }
}