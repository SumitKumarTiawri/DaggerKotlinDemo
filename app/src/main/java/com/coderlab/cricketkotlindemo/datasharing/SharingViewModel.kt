package com.coderlab.cricketkotlindemo.datasharing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharingViewModel : ViewModel() {

    private val data: MutableLiveData<String> = MutableLiveData()

    fun getData(): LiveData<String> {
        return data
    }

    fun setData(value: String) {
        data.postValue(value)
    }

}