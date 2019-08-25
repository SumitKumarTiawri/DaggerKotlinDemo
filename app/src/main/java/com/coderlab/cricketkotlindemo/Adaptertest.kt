package com.coderlab.cricketkotlindemo

import android.util.Log
import javax.inject.Inject

class Adaptertest @Inject constructor() {

    fun print() {
        Log.e("print", toString())
    }
}