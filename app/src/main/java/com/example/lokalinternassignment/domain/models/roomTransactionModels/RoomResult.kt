package com.example.lokalinternassignment.domain.models.roomTransactionModels

sealed class RoomResult <out T> {
    object Loading : RoomResult<Nothing>()
    data class Success <T> (val data : T) : RoomResult<T>()
    data class Error (val error: String ) : RoomResult<Nothing>()
    data class Cancelled (val cancelleationMsg: String ) : RoomResult<Nothing>()

}