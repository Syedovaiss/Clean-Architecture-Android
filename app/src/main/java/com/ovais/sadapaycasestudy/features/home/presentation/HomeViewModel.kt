package com.ovais.sadapaycasestudy.features.home.presentation

import androidx.lifecycle.*
import com.ovais.sadapaycasestudy.base.BaseViewModel
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.features.home.domain.GithubRepositoriesUseCase
import com.ovais.sadapaycasestudy.managers.ToastManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val githubHomeUseCase: GithubRepositoriesUseCase,
    private val toastManager: ToastManager
) : BaseViewModel() {

    val githubRepositoriesData: LiveData<GithubRepositoryUIData>
        get() = _githubRepositoriesData
    private val _githubRepositoriesData: MutableLiveData<GithubRepositoryUIData> by lazy { MutableLiveData() }


    fun initGithubRepositories() {
        fetchGithubRepositories()
    }

    private fun fetchGithubRepositories() {
        unzipFlowResults(githubHomeUseCase(Unit), onSuccess = { response ->
            _githubRepositoriesData.value = response as GithubRepositoryUIData
        }, onError = { error ->
            toastManager.showToast(error)
        })
    }
}