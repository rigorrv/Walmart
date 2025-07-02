package com.example.walmart.api

import com.example.walmart.model.CountryResponse
import com.example.walmart.utilities.ApplicationUtilities.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(END_POINT)
    suspend fun getCountries(): Response<CountryResponse?>
}