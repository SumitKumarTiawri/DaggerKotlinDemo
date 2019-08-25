package com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.screens.mainscreen.model.UserData
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainScreenFragment : Fragment() {
    @Inject
    lateinit var userData: UserData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("dagger", "Fragment UserData > $userData > value ${userData.username}")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}