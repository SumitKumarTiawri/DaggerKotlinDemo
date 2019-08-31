package com.coderlab.cricketkotlindemo.fragmentrd

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("BaseFragment", " ${this.javaClass.simpleName} > onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("BaseFragment", " ${this.javaClass.simpleName} > onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isClickable = true
        view.setBackgroundColor(Color.WHITE)
        Log.e("BaseFragment", " ${this.javaClass.simpleName} > onViewCreated()")
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        Log.e("BaseFragment", " ${this.javaClass.simpleName} > onActivityCreated()")
//    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e("BaseFragment", " ${this.javaClass.simpleName} > onAttach()")
    }

    open fun onBackPressed(): Boolean {
        for (i in 0 until (activity?.supportFragmentManager?.getBackStackEntryCount() ?: 0)) {
            Log.e("onBackPressed", activity?.supportFragmentManager?.fragments?.get(i)?.javaClass?.simpleName)
        }
        return true
    }


}