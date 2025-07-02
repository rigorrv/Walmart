package com.example.walmart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmart.model.CountryDomain
import com.example.walmart.repository.ApiRepository
import kotlinx.coroutines.launch

class CountryVM(private val repository: ApiRepository) : ViewModel() {

    private val _countriesLiveData = MutableLiveData<Result<CountryDomain?>>(null)
    val countriesLiveData: LiveData<Result<CountryDomain?>> = _countriesLiveData

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            repository.getCountries().let { data ->
                _countriesLiveData.value = data
            }
        }
    }
}