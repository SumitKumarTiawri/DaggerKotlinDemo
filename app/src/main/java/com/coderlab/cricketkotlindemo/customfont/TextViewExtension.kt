package com.coderlab.cricketkotlindemo.customfont

import android.content.Context
import android.graphics.Typeface
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.widget.TextView
import androidx.core.provider.FontRequest
import androidx.core.provider.FontsContractCompat
import com.coderlab.cricketkotlindemo.R

fun loadFont(context: Context, font: CustomFont, func: (Typeface) -> Unit) {
    val handlerThread = HandlerThread("fonts").apply { start() }
    val handler = Handler(handlerThread.looper)
    val request = FontRequest(
        "com.google.android.gms.fonts",
        "com.google.android.gms",
        font.query,
        R.array.com_google_android_gms_fonts_certs
    )

    FontsContractCompat.requestFont(
        context,
        request,
        object : FontsContractCompat.FontRequestCallback() {
            override fun onTypefaceRetrieved(typeface: Typeface) {
                func.invoke(typeface)
            }

            override fun onTypefaceRequestFailed(reason: Int) {
                Log.e(
                    "loadFont",
                    "FontsContractCompat . requestFont failed with error code $reason"
                )
            }
        },
        handler
    )
}

enum class CustomFont(val query: String) {
    MONTSERRAT_REGULAR("Montserrat"),
    MONTSERRAT_LIGHT("name=Montserrat&weight=300"),
    MONTSERRAT_SEMI_BOLD("name=Montserrat&weight=600"),
}

fun TextView.setCustomFont(customFont: CustomFont) {
    loadFont(context, customFont) {
        this.typeface = it
    }
}