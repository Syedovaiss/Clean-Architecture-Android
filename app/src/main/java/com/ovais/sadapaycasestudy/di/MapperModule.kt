package com.ovais.sadapaycasestudy.di

import com.ovais.sadapaycasestudy.utils.DefaultErrorStateMapper
import com.ovais.sadapaycasestudy.utils.ErrorStateMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun providesErrorStateMapper(defaultErrorStateMapper: DefaultErrorStateMapper): ErrorStateMapper
}