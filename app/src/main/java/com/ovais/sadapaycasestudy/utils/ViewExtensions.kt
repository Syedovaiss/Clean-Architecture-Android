package com.ovais.sadapaycasestudy.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View

val View.inflater
    get() = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}
