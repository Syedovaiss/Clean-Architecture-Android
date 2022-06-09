package com.ovais.sadapaycasestudy.di

import com.ovais.sadapaycasestudy.managers.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {

    @Binds
    fun bindStringProvider(defaultStringResourceManager: DefaultStringResourceManager):StringResourceManager

    @Binds
    fun bindToastProvider(defaultToastManager: DefaultToastManager):ToastManager
}