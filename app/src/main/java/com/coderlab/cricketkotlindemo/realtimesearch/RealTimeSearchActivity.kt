package com.coderlab.cricketkotlindemo.realtimesearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.orientation.ActivityA
import com.coderlab.cricketkotlindemo.realtimesearch.adapter.SearchAdapter
import com.coderlab.cricketkotlindemo.realtimesearch.model.SearchItem
import com.coderlab.cricketkotlindemo.realtimesearch.viewmodel.RealtimeViewModel

class RealTimeSearchActivity : AppCompatActivity() {
    private val adapter: SearchAdapter by lazy {
        SearchAdapter(this, R.layout.item_search_list)
    }

    private val autoCompleteTextView: AutoCompleteTextView by lazy {
        val view = findViewById<AutoCompleteTextView>(R.id.auto_complete_text_view)
        view.threshold = 2
        view
    }

    private val viewModel: RealtimeViewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return RealtimeViewModel() as T
            }
        }).get(RealtimeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_time_search)
        autoCompleteTextView.setAdapter(adapter)
        viewModel.searchData.observe(this, Observer<List<SearchItem>> { t -> adapter.setItems(t) })
        autoCompleteTextView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.e("onItemClick", adapter.getItem(position).toString())
                autoCompleteTextView.setText("")
            }
        }

        autoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.query(s?.toString() ?: "")
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        ActivityA.startActivityA(this, "Holla")

    }
}