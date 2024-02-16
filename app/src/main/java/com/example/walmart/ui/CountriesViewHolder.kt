package com.example.walmart.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.R
import com.example.walmart.model.CountryDBItem

class CountriesViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    private val nameTxt: TextView = itemView.findViewById(R.id.nameTxt)
    private val regionTxt: TextView = itemView.findViewById(R.id.regionTxt)
    private val codeTxt: TextView = itemView.findViewById(R.id.codeTxt)
    private val capitalTxt: TextView = itemView.findViewById(R.id.capitalTxt)

    fun onBind(item: CountryDBItem) {
        item.run {
            val space = itemView.context.getString(R.string.space_name) + region
            nameTxt.text = name
            regionTxt.text = space
            codeTxt.text = code
            capitalTxt.text = capital
        }
    }
}