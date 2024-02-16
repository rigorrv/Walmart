package com.example.walmart.repository

import com.example.walmart.model.CountryDomain

interface ApiRepository {

    suspend fun getCountries(): CountryDomain?
}