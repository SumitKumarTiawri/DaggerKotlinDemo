package com.coderlab.cricketkotlindemo.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter


object BindingAdapter {
    @BindingAdapter(value = ["app:hello"])
    @JvmStatic
    fun setText(textView: TextView, value: String?) {
        textView.text = value
    }
}