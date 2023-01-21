package com.example.exteraedgeassigment.data.network

import com.example.exteraedgeassigment.data.network.Constants.Companion.ROCKETS
import com.example.exteraedgeassigment.data.network.model.response.RocketListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(ROCKETS)
    suspend fun getRocketsList(): Response<List<RocketListResponse>>

    @GET("$ROCKETS/{ID}")
    suspend fun getRocketDetails(@Path("ID") id:String) : Response<RocketListResponse>
}