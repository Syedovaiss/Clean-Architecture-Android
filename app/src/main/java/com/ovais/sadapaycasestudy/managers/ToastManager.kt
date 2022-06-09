package com.ovais.sadapaycasestudy.managers

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ToastManager {

    fun showToast(message: Any)
}

class DefaultToastManager @Inject constructor(@ApplicationContext private val appContext: Context) :
    ToastManager {

    override fun showToast(message: Any) {
        Toast.makeText(appContext, message.toString(), Toast.LENGTH_SHORT).show()
    }
}