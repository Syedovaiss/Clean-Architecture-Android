package com.ovais.sadapaycasestudy.managers

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext

interface ToastManager {

    fun showToast(message: Any)
}

class DefaultToastManager(@ApplicationContext private val appContext: Context) : ToastManager {

    override fun showToast(message: Any) {
        Toast.makeText(appContext, message.toString(), Toast.LENGTH_SHORT).show()
    }
}