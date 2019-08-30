package com.coderlab.cricketkotlindemo.realtimesearch.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.realtimesearch.model.SearchItem

class SearchAdapter(context: Context, layout: Int) : ArrayAdapter<SearchItem>(context, layout),
    Filterable {

    private var items: List<SearchItem> = listOf()
    private var originalData: List<SearchItem> = listOf()

    public fun setItems(items: List<SearchItem>?) {
        this.items = items?.let { it } ?: listOf()
        this.originalData = items?.let { it } ?: listOf()
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): SearchItem? {
        return items.get(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val convertView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_list, parent, false) as TextView
        convertView.text = getItem(position)?.name
        return convertView
    }

    override fun getFilter(): Filter {
        val filter: Filter = object : Filter() {
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                results?.let {
                    items = it.values as List<SearchItem>
                    notifyDataSetChanged();
                } ?: run {
                    items = originalData
                    notifyDataSetInvalidated();
                }
            }

            @SuppressLint("DefaultLocale")
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val results = FilterResults()
                if (constraint.isNullOrEmpty()) {
                    results.values = originalData
                    results.count = originalData.size
                } else {
                    val filterString = constraint.toString().toLowerCase()
                    val list = originalData
                    val newList: MutableList<SearchItem> = mutableListOf()
                    for (i in 0 until list.size) {
                        if (list[i].name?.toLowerCase()?.contains(filterString) == true) {
                            newList.add(list.get(i))
                        }
                    }
                    results.values = newList
                    results.count = newList.size
                }
                return results
            }
        }
        return filter
    }
}