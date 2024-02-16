package com.example.walmart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmart.model.CountryDB
import com.example.walmart.repository.Repository
import kotlinx.coroutines.launch

class CountryVM(private val repository: Repository) : ViewModel() {

    private val _countriesLiveData = MutableLiveData<CountryDB?>(null)
    val countriesLiveData: LiveData<CountryDB?> = _countriesLiveData

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            repository.getCountries().apply {
                _countriesLiveData.value = this
            }
        }
    }
}