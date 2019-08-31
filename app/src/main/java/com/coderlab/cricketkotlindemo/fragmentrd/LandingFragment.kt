package com.coderlab.cricketkotlindemo.fragmentrd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coderlab.cricketkotlindemo.R
import kotlinx.android.synthetic.main.fragment_landing.view.*

class LandingFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        retainInstance = true
        return inflater.inflate(R.layout.fragment_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.open_category.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.container, CategoryFragment(), "CategoryFragment")
                ?.addToBackStack("CategoryFragment")
                ?.commit()
        }
    }
}