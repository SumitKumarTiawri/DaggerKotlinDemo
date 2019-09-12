package com.coderlab.cricketkotlindemo.datasharing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coderlab.cricketkotlindemo.R
import kotlinx.android.synthetic.main.fragment_sub_data_sharing.*

class SubFragment : Fragment() {

    val viewModelKey: String by lazy {
        arguments?.getString("viewModelKey") ?: ""
    }
    val viewModel: SharingViewModel by lazy {
        ViewModelProvider(requireActivity(), object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SharingViewModel() as T
            }
        }).get(viewModelKey, SharingViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sub_data_sharing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                shared_data.text = t
            }

        })

    }


}