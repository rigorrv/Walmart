package com.example.walmart.repository

import com.example.walmart.model.CountryDB
import retrofit2.HttpException
import java.io.IOException

class Repository(private val repository: RetrofitRepository) : ApiRepository {

    override suspend fun getCountries(): CountryDB? {
        return try {
            repository.getApi().getCountries().let {
                if (it.isSuccessful) it.body() else null
            }
        } catch (e: HttpException) {
            print(e.code())
            return null
        } catch (e: IOException) {
            print(e)
            return null
        } catch (e: Exception) {
            print(e)
            return null
        }
    }
}