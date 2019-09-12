package com.coderlab.cricketkotlindemo.datasharing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coderlab.cricketkotlindemo.R
import kotlinx.android.synthetic.main.fragment_data_sharing_home.*

class DataSharingHomeFragment : Fragment() {

    val categoryId: Int by lazy {
        arguments?.getInt("key") ?: 0
    }


    val viewModel: SharingViewModel by lazy {
        ViewModelProvider(requireActivity(), object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SharingViewModel() as T
            }
        }).get(Integer.toHexString(hashCode()), SharingViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_data_sharing_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setData(categoryId.toString())
        category_id.text = "$categoryId"
        detail.setOnClickListener {
            val fragment = SubFragment()
            fragment.arguments = Bundle().also { it.putString("viewModelKey", Integer.toHexString(hashCode())) }
            activity?.supportFragmentManager?.beginTransaction()?.add(R.id.home_container, fragment, "SubFragment")
                ?.addToBackStack("SubFragment")?.commit()
        }
    }

}