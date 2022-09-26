package com.example.retrofit

import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {
    @GET("slack")
    fun getJoke(@Query("format") format:String):Call<Joke>
}