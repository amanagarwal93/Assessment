package com.example.assessment.retrofit

import Data
import com.example.assessment.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v1/gifs/trending?")
    fun getGif(@Query("api_key") apiKey: String, @Query("limit") limit: Int): Call<Data>
}