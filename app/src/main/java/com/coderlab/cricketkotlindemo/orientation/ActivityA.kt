package com.coderlab.cricketkotlindemo.orientation

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.coderlab.cricketkotlindemo.R

class ActivityA : AppCompatActivity() {


    companion object {
        fun startActivityA(context: Context, value: String) {
            val intent = Intent(context, ActivityA::class.java)
            intent.putExtra("arg_value", value)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Log.e("arg_value", intent.getStringExtra("arg_value"))
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("arg_value", intent.getStringExtra("arg_value"))

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (newConfig?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.e("orientation", "ORIENTATION_LANDSCAPE")
        } else if (newConfig?.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.e("orientation", "ORIENTATION_LANDSCAPE")
        } else {
            Log.e("orientation", "ORIENTATION_NOT_SURE")
        }
    }
}