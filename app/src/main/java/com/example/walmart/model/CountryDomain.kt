package com.example.walmart.model

data class CountryDomain(
    val countryItems: List<CountryItems?>
)

data class CountryItems(
    val name: String?,
    val region: String?,
    val code: String?,
    val capital: String?
)
