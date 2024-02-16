package com.example.walmart.repository

import com.example.walmart.model.CountryDomain
import com.example.walmart.model.CountryItems
import com.example.walmart.model.CountryResponse
import okio.IOException

class RepositoryImpl(private val repository: RetrofitRepository) : ApiRepository {

    override suspend fun getCountries(): CountryDomain? {
        return runCatching {
            repository.getApi().getCountries()
        }.mapCatching { response ->
            if (response.isSuccessful) {
                response.body()?.toDomain() ?: throw NullPointerException("body is empty")
            } else {
                throw IOException("Api Error")
            }
        }.onFailure { throwable ->
            println("Error: ${throwable.message}")
        }.getOrDefault(null)
    }

    private fun CountryResponse.toDomain(): CountryDomain {
        return CountryDomain(
            countryItems = supplementalObjectsMapping()
        )
    }

    private fun CountryResponse.supplementalObjectsMapping(): List<CountryItems> {
        return this.map { info ->
            CountryItems(
                name = info?.name,
                region = info?.region,
                code = info?.code,
                capital = info?.capital
            )
        }
    }
}