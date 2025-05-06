package com.example.lokalinternassignment.domain.models.retrofitTransactionModels

sealed class RetrofitResult<out T> {
    object Loading : RetrofitResult<Nothing>()
    data class Success<T>(val data: T) : RetrofitResult<T>()
    data class Error(val error: String) : RetrofitResult<Nothing>()

}