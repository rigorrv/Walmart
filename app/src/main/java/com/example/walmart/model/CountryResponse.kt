package com.example.walmart.model

import com.google.gson.annotations.SerializedName

class CountryResponse : ArrayList<CountryDBItem?>()

data class CountryDBItem(
    val capital: String?,
    val code: String?,
    val currency: Currency?,
    val demonym: String?,
    val flag: String?,
    val language: Language?,
    val name: String?,
    val region: String?,
)

data class Currency(
    val code: String?,
    val name: String?,
    val symbol: String?,
)

data class Language(
    val code: String?,
    @SerializedName("iso639_2")
    val iso6392: String?,
    val name: String?,
    val nativeName: String?,
)