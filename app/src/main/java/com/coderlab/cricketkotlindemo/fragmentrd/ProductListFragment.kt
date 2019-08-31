package com.coderlab.cricketkotlindemo.fragmentrd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coderlab.cricketkotlindemo.R
import kotlinx.android.synthetic.main.fragment_product.view.*


class ProductListFragment : BaseFragment() {

    companion object Factory {
        fun newInstance(query: String? = null): ProductListFragment {
            val instance = ProductListFragment()
            val bundle = Bundle()
            bundle.putString("key", query)
            instance.arguments = bundle
            return instance
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        retainInstance = true
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.query_text.text = arguments?.getString("key").toString()
    }

    override fun onBackPressed(): Boolean {
        activity?.supportFragmentManager?.popBackStack("SubCategoryFragment", 0);
        return false
    }


}