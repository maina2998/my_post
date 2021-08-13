package com.example.myposts

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Apiclient {
    var retrofit =Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> buildService(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)

    }


}