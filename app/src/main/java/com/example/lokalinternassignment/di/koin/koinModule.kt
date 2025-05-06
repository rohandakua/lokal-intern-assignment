package com.example.lokalinternassignment.di.koin

import androidx.room.Room
import com.example.lokalinternassignment.data.offline.room.JobDatabase
import com.example.lokalinternassignment.data.offline.room.RoomRepositoryImplementation
import com.example.lokalinternassignment.domain.constant.endpoint
import com.example.lokalinternassignment.domain.interfaces.RetrofitRepository
import com.example.lokalinternassignment.domain.interfaces.RoomRepository
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
            .baseUrl(endpoint)
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


}