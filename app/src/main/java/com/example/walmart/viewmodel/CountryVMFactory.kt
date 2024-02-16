package com.example.walmart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walmart.repository.RepositoryImpl
import com.example.walmart.repository.RetrofitRepository

class CountryVMFactory: ViewModelProvider.Factory {

    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryVM(repository = RepositoryImpl(RetrofitRepository())) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}