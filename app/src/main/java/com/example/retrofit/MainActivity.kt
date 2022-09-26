package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadJoke()
    }

    private fun loadJoke() {
        val BASE_URL="https://icanhazdadjoke.com/"
        val tvJoke= findViewById<TextView>(R.id.tvJoke)
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService:JokeService
        jokeService = retrofit.create(JokeService::class.java)

        val request = jokeService.getJoke("json")

        request.enqueue(object :Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful){
                    println(response.body()!!.attachments)
                    tvJoke.text = response.body()!!.attachments[0].text
                    Toast.makeText(this@MainActivity, "Tu joki random está listo :D", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                println("ERROR")
            }

        })


    }
}