package com.example.walmart.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.R
import com.example.walmart.model.CountryItems

class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTxt: TextView = this.itemView.findViewById(R.id.nameTxt)
    private val regionTxt: TextView = this.itemView.findViewById(R.id.regionTxt)
    private val codeTxt: TextView = this.itemView.findViewById(R.id.codeTxt)
    private val capitalTxt: TextView = this.itemView.findViewById(R.id.capitalTxt)

    fun onBind(item: CountryItems?) {
        item?.run {
            val space = itemView.context.getString(R.string.space_name) + region
            nameTxt.text = name
            regionTxt.text = space
            codeTxt.text = code
            capitalTxt.text = capital
        }
    }
}