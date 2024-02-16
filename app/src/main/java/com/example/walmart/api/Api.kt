package com.example.walmart.api

import com.example.walmart.model.CountryDB
import com.example.walmart.utilities.ApplicationUtilities.endPoint
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(endPoint)
    suspend fun getCountries(): Response<CountryDB?>
}