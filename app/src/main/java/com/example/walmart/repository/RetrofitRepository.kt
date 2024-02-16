package com.example.walmart.repository

import com.example.walmart.api.Api
import com.example.walmart.utilities.ApplicationUtilities.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository {

    private val client = OkHttpClient().newBuilder().build()

    private val retrofitRepo =
        Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

    fun getApi(): Api = retrofitRepo.create(Api::class.java)
}
