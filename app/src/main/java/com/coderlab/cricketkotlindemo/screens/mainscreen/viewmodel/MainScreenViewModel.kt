package com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.coderlab.cricketkotlindemo.BaseApplication

class MainScreenViewModel(private val application: BaseApplication) :
    AndroidViewModel(application) {

    val listOfItems: MutableLiveData<String> = MutableLiveData()

    fun addSomeValue(value: String) {
        listOfItems.postValue(value)
    }

}