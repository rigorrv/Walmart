package com.example.walmart

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.ui.CountriesAdapter
import com.example.walmart.viewmodel.CountryVM
import com.example.walmart.viewmodel.CountryVMFactory


class MainActivity : ComponentActivity() {

    private val adapter = CountriesAdapter()
    private val viewModel: CountryVM by lazy {
        ViewModelProvider(this, CountryVMFactory())[CountryVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        viewModel.countriesLiveData.observe(this) { data ->
            data?.let { info ->
                when {
                    info.isSuccess -> {
                        info.getOrNull()?.countryItems?.let {
                            adapter.getCountryList(it)
                        }
                        recyclerView.adapter = adapter
                    }

                    info.isFailure -> {
                        showSimpleAlertDialog()
                    }
                }
            }
        }
    }

    private fun showSimpleAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.error_msg))
        builder.setMessage(getString(R.string.something_went_wrong_msg))
        val dialog = builder.create()
        dialog.show()
    }

}