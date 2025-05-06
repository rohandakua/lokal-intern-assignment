package com.example.lokalinternassignment.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.domain.helperFunction.toEachJob
import com.example.lokalinternassignment.domain.models.apiModels.Job
import com.example.lokalinternassignment.domain.models.apiModels.Results
import com.example.lokalinternassignment.domain.models.retrofitTransactionModels.RetrofitResult
import com.example.lokalinternassignment.domain.models.roomTransactionModels.RoomResult
import com.example.lokalinternassignment.domain.usecase.retrofitUsecases.GetJobUsecase
import com.example.lokalinternassignment.domain.usecase.roomUsecases.BookmarkJob
import com.example.lokalinternassignment.domain.usecase.roomUsecases.DeleteBookmarkedJobById
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class JobPageViewModel(
    private val getJobUsecase: GetJobUsecase,
    private val bookmarkJob: BookmarkJob,
    private val deleteBookmarkedJobById: DeleteBookmarkedJobById
) : ViewModel() {
    private val TAG = "JobPageViewModel"


    private val _jobs =
        MutableLiveData<List<EachJob>>(emptyList())  // we are using EachJob model from room to display the jobs, the

    // Job model is used only to fetch from the api
    val jobs: LiveData<List<EachJob>> = _jobs

    private val _jobLoadingState = MutableLiveData<RetrofitResult<Unit>>(RetrofitResult.Loading)
    val jobLoadingState: LiveData<RetrofitResult<Unit>> = _jobLoadingState

    private var currentPage = 1
    private var isLastPage = false

    /**
     * @Function fetchJobs is used to fetch the job list
     * It handles the page no. as well
     */
    fun fetchJobs() {
        if (isLastPage || _jobLoadingState.value is RetrofitResult.Loading) return

        viewModelScope.launch {
            _jobLoadingState.value = RetrofitResult.Loading
            when (val result = getJobUsecase.execute(currentPage)) {
                is RetrofitResult.Success -> {
                    val newJobs = result.data.results
                    val updatedJobs = _jobs.value?.toMutableList() ?: mutableListOf()
                    updatedJobs.addAll(newJobs.map { job -> job.toEachJob() })
                    _jobs.value = updatedJobs
                    if (newJobs.isEmpty()) isLastPage = true
                    currentPage++
                    _jobLoadingState.value = RetrofitResult.Success(Unit)
                }

                is RetrofitResult.Error -> {
                    _jobLoadingState.value = RetrofitResult.Error("error occured")
                }

                else -> {
                    Log.e(TAG, "fetchJobs: error occured")
                }
            }
        }
    }


    private val _bookmarkLoadingState = MutableLiveData<RoomResult<Unit>>(RoomResult.Idle)
    val bookmarkLoadingState: LiveData<RoomResult<Unit>> = _bookmarkLoadingState
    // i am not writing logic for all the objects of the list, so this will work for the whole system
    // if any page is in the process of bookmarking then user can't use the bookmark button for other pages
        // and a spinner obj. will be shown in the complete screen

    fun bookmarkJob(job: EachJob) {
        viewModelScope.launch {
            job.is_bookmarked = true
            when (val result = bookmarkJob.execute(job)) {
                is RoomResult.Success -> {
                    _bookmarkLoadingState.value = RoomResult.Success(Unit)
                }
                else -> {
                    Log.e(TAG, "bookmarkJob: error occured")
                    job.is_bookmarked = false
                    _bookmarkLoadingState.value = RoomResult.Error("error occured")

                }
            }
        }
    }

    var lastViewedIndex = -1


    fun deleteBookmarkedJob(jid : Int) {
        viewModelScope.launch {
            val currentJobs = _jobs.value ?: emptyList()
            val jobToDelete = currentJobs.indexOfFirst { it.jid == jid }
            if(jobToDelete <0 ) return@launch
            when (val result = deleteBookmarkedJobById.execute(jid)) {
                is RoomResult.Success -> {
                    val updatedJob = currentJobs[jobToDelete].copy(is_bookmarked = false)

                    // update the list
                    val updatedJobs = currentJobs.toMutableList().apply {
                        set(jobToDelete, updatedJob)
                    }
                    _jobs.value = updatedJobs
                    lastViewedIndex = if (jobToDelete>0) jobToDelete -1 else 0
                } else -> {
                    Log.e(TAG , "deleteBookmarkedJob: error occured")
                }
            }
        }
    }



}