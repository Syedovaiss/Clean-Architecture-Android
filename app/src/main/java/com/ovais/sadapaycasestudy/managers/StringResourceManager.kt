package com.ovais.sadapaycasestudy.managers

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface StringResourceManager {

    fun getString(@StringRes resId: Int): String
    fun getString(@StringRes resId: Int, args: String): String
}

class DefaultStringResourceManager @Inject constructor(@ApplicationContext private val appContext: Context) :
    StringResourceManager {

    override fun getString(resId: Int) = appContext.getString(resId)

    override fun getString(resId: Int, args: String) = appContext.getString(resId, args)

}