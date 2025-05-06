package com.example.lokalinternassignment.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult
import com.example.lokalinternassignment.domain.usecase.roomUsecases.DeleteBookmarkedJobById
import com.example.lokalinternassignment.domain.usecase.roomUsecases.GetAllBookmarkedJobs
import kotlinx.coroutines.launch

class BookmarksPageViewModel(
    private val getAllBookmarkedJobs: GetAllBookmarkedJobs,
    private val deleteBookmarkedJobById: DeleteBookmarkedJobById
) : ViewModel() {
    private  val TAG = "BookmarksPageViewModel"

    private val _bookmarkedJobs = MutableLiveData<List<EachJob>>(emptyList())
    val bookmarkedJobs: LiveData<List<EachJob>> = _bookmarkedJobs

    private val _bookmarkLoadingState = MutableLiveData<RoomResult<Unit>>(RoomResult.Idle)
    val bookmarkLoadingState: LiveData<RoomResult<Unit>> = _bookmarkLoadingState

    fun fetchBookmarkedJobs() {
        _bookmarkLoadingState.value = RoomResult.Loading
        viewModelScope.launch {
            when (val result = getAllBookmarkedJobs.execute()) {
                is RoomResult.Success -> {
                    _bookmarkedJobs.value = result.data
                    _bookmarkLoadingState.value = RoomResult.Success(Unit)
                }
                else -> {
                    Log.e(TAG, "fetchBookmarkedJobs: error occured")
                    _bookmarkLoadingState.value = RoomResult.Idle
                }
            }
        }
    }

    var lastViewedIndex = -1
    fun getLastViewedIndex(): Int = lastViewedIndex


    fun deleteBookmarkedJob(jid : Int) {
        viewModelScope.launch {
            val currentJobs = _bookmarkedJobs.value ?: emptyList()
            val jobToDelete = currentJobs.indexOfFirst { it.jid == jid }
            when (val result = deleteBookmarkedJobById.execute(jid)) {
                is RoomResult.Success -> {
                    // update the list
                    val updatedJobs = currentJobs.filter { it.jid != jid }
                    _bookmarkedJobs.value = updatedJobs
                    lastViewedIndex = if (jobToDelete>0) jobToDelete -1 else 0
                } else -> {
                Log.e(TAG , "deleteBookmarkedJob: error occured")
            }
            }
        }
    }


}