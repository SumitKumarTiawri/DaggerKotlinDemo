package com.coderlab.cricketkotlindemo.fragmentrd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coderlab.cricketkotlindemo.R
import kotlinx.android.synthetic.main.fragment_sub_category.view.*

class SubCategoryFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        retainInstance = true
        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.category_button.setOnClickListener {
            // if you don't want this fragment in backstack
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commitNow()
//            activity?.supportFragmentManager?.popBackStack();
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.add(R.id.container, ProductListFragment.newInstance("From Sub Category"), "ProductListFragment")
                ?.addToBackStack("ProductListFragment")
                ?.commit()
        }
    }

    override fun onBackPressed(): Boolean {
        return super.onBackPressed()

    }
}