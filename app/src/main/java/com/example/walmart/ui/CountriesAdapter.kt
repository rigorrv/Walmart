package com.example.walmart.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.R
import com.example.walmart.model.CountryItems

class CountriesAdapter : RecyclerView.Adapter<CountriesViewHolder>() {

    private var countryList = listOf<CountryItems?>()

    fun getCountryList(items: List<CountryItems?>) {
        countryList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.countries_view, parent, false)

        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        countryList[position].let { holder.onBind(it) }
    }

    override fun getItemCount(): Int = countryList.size
}