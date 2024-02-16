package com.example.walmart.repository

import com.example.walmart.api.Api
import com.example.walmart.utilities.ApplicationUtilities.baseUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository {

    private val client = OkHttpClient()
        .newBuilder()
        .build()

    private val retrofitRepo =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

    fun getApi(): Api = retrofitRepo.create(Api::class.java)
}
