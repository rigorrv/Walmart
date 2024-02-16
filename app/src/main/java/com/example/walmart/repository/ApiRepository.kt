package com.example.walmart.repository

import com.example.walmart.model.CountryDB

interface ApiRepository {

    suspend fun getCountries(): CountryDB?
}