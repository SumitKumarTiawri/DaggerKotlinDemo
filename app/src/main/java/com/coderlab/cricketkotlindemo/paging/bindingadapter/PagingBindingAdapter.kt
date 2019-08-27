package com.coderlab.cricketkotlindemo.paging.bindingadapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class PagingBindingAdapter {
    @BindingAdapter("app:sumit_url")
    fun setImageFromUrl(imageView: ImageView, url: String?) {
        url.let {
            Glide.with(imageView)
                .load(it!!)
                .error(null as Drawable?)
                .into(imageView)

        }
    }
}