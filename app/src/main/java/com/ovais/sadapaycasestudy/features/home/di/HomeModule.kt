package com.ovais.sadapaycasestudy.features.home.di

import com.ovais.sadapaycasestudy.features.home.data.DefaultGithubRepositoryMapper
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryMapper
import com.ovais.sadapaycasestudy.features.home.domain.*
import com.ovais.sadapaycasestudy.features.home.services.HomeAPIService
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class HomeProviderModule {

    @Provides
    fun providesHomeAPIService(retrofit: Retrofit) = retrofit.create(HomeAPIService::class.java)
}

@Module
@InstallIn(ViewModelComponent::class)
interface HomeBinderModule {

    @Binds
    fun bindRepositoryResponseMapper(defaultGithubRepositoryMapper: DefaultGithubRepositoryMapper): GithubRepositoryMapper

    @Binds
    fun bindGithubHomeUseCase(defaultGithubHomeUseCase: DefaultGithubRepositoriesUseCase): GithubRepositoriesUseCase

    @Binds
    fun bindGithubHomeRepository(defaultGithubHomeRepository: DefaultGithubHomeRepository): GithubHomeRepository

}
