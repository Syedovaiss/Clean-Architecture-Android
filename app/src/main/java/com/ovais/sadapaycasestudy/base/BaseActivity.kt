package com.ovais.sadapaycasestudy.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        init()
    }

    abstract fun getLayout(): Int

    protected open fun init() = Unit
}