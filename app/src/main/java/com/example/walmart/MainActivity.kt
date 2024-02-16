package com.example.walmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.ui.CountriesAdapter
import com.example.walmart.viewmodel.CountryVM
import com.example.walmart.viewmodel.CountryVMFactory


class MainActivity : ComponentActivity() {

    private lateinit var adapter: CountriesAdapter
    private val viewModel: CountryVM by lazy {
        ViewModelProvider(this, CountryVMFactory())[CountryVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        viewModel.countriesLiveData.observe(this) { data ->
            data?.let {
                adapter = CountriesAdapter(it)
                recyclerView.adapter = adapter
            }
        }
    }
}