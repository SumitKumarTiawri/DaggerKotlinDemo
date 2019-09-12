package com.coderlab.cricketkotlindemo.model

import android.content.Context
import android.content.SharedPreferences
import com.coderlab.cricketkotlindemo.dagger.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Storage @Inject constructor(@ApplicationContext val context: Context) {

    val sharedPreference: SharedPreferences =
        context.getSharedPreferences("app_global", Context.MODE_PRIVATE)


    fun add(key: String, value: String) {
        sharedPreference.edit().putString(key, value).apply()
    }

    fun get(key: String): String {
        return sharedPreference.getString(key, "") ?: ""
    }
}