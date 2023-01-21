package com.example.exteraedgeassigment.di

import android.content.Context
import androidx.room.Room
import com.example.exteraedgeassigment.data.network.Constants.Companion.BASE_URL
import com.example.exteraedgeassigment.data.MainRepositoryImp
import com.example.exteraedgeassigment.data.local.DbRepositoryImpl
import com.example.exteraedgeassigment.data.local.RocketDatabase
import com.example.exteraedgeassigment.data.network.ApiService
import com.example.exteraedgeassigment.data.network.repository.RocketRepositoryImpl
import com.example.exteraedgeassigment.domain.MainRepository
import com.example.exteraedgeassigment.domain.local.repository.DbRepository
import com.example.exteraedgeassigment.domain.network.repository.RocketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesRestApi(): ApiService =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)

    @Provides
    fun providesRocketRepository(): RocketRepository = RocketRepositoryImpl(providesRestApi())

    @Provides
    @Singleton
    fun providesRocketDatabase(@ApplicationContext app: Context): RocketDatabase =
        Room.databaseBuilder(app, RocketDatabase::class.java, "rocket_database").build()

    @Provides
    fun providesDbRepository(@ApplicationContext app: Context): DbRepository = DbRepositoryImpl(providesRocketDatabase(app))

    @Provides
    fun providesMainRepository(@ApplicationContext app: Context): MainRepository = MainRepositoryImp(providesRocketRepository(),
        providesDbRepository(app), providesRocketDatabase(app))
}