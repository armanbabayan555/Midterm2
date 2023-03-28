package com.example.midterm2.data

import retrofit2.Response
import retrofit2.http.GET


interface MyApiService {

    @GET("api/?inc=nat,name,email&results=100")
    suspend fun fetchUsers(): Response<FullJson>

}


