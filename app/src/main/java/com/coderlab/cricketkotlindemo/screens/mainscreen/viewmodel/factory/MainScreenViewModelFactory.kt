package com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coderlab.cricketkotlindemo.BaseApplication
import com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.MainScreenViewModel

class MainScreenViewModelFactory(private val application: BaseApplication) :
    ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainScreenViewModel(application = application) as T
    }
}