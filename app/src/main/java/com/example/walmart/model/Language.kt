package com.example.walmart.model

import com.google.gson.annotations.SerializedName

data class Language(
    val code: String? = null,
    @SerializedName("iso639_2")
    val iso6392: String? = null,
    val name: String? = null,
    val nativeName: String? = null,
)