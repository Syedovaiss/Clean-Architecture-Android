package com.ovais.sadapaycasestudy.utils

import com.ovais.sadapaycasestudy.utils.Constants.EMPTY_STRING

fun String?.default(any: String? = null) = this ?: any ?: EMPTY_STRING
fun Int?.default(any: Int? = null) = this ?: any ?: 0

fun <T> List<T>?.orEmptyList(): List<T> = this ?: listOf()

fun <T> List<T>?.toArrayList(): ArrayList<T> {
    return if (this.isNullOrEmpty()) {
        arrayListOf()
    } else {
        this as ArrayList<T>
    }
}

val Boolean?.default get() = this ?: false