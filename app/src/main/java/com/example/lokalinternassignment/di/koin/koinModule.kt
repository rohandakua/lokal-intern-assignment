package com.example.lokalinternassignment.di.koin

import androidx.room.Room
import com.example.lokalinternassignment.data.offline.room.JobDatabase
import com.example.lokalinternassignment.data.offline.room.RoomRepositoryImplementation
import com.example.lokalinternassignment.data.online.retrofit.RetrofitRepositoryImplementation
import com.example.lokalinternassignment.domain.constant.baseURL
import com.example.lokalinternassignment.domain.interfaces.RetrofitRepository
import com.example.lokalinternassignment.domain.usecase.retrofitUsecases.GetJobUsecase
import com.example.lokalinternassignment.domain.usecase.roomUsecases.BookmarkJob
import com.example.lokalinternassignment.domain.usecase.roomUsecases.DeleteBookmarkedJobById
import com.example.lokalinternassignment.domain.usecase.roomUsecases.GetAllBookmarkedJobs
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val koinModule = module {

    // room database provider
    single{
        Room.databaseBuilder(context = get() , JobDatabase::class.java , name = "job_database").build()
    }

    // for each job dao
    single {
        get<JobDatabase>().eachJobDao()
    }

    // for Retrofit client
    single {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // for providing the Rertofit Repository
    single {
        get<Retrofit>().create(RetrofitRepository::class.java)
    }

    // for providing the Room Repository Implementation
    single {
        RoomRepositoryImplementation(dao = get())
    }

    // for providigin the Retrofit Repository Implementation
    single {
        RetrofitRepositoryImplementation(api = get())
    }

    // usecases
    factory { GetJobUsecase(repository = get()) }
    factory { BookmarkJob(repository = get()) }
    factory { GetAllBookmarkedJobs(repository = get()) }
    factory { DeleteBookmarkedJobById(repository = get()) }


}