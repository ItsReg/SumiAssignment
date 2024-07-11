package com.example.sumiassignment

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    fun getAllData(): Call<List<ImageData>>

}
