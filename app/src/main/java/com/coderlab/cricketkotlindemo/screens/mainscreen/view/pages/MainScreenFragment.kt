package com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.screens.mainscreen.model.UserData
import com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.MainScreenViewModel
import com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.factory.MainScreenViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainScreenFragment : Fragment() {
    @Inject
    lateinit var userData: UserData
    @Inject
    lateinit var viewModelFactory: MainScreenViewModelFactory

    lateinit var viewModel: MainScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(activity!!, viewModelFactory).get(MainScreenViewModel::class.java)
        Log.e("dagger", "Fragment UserData > $userData > value ${userData.username}")

        viewModel.listOfItems.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.e("viewModel", " MainScreenFragment > $t")
            }
        })
        //  viewModel.addSomeValue("Add activity value")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}