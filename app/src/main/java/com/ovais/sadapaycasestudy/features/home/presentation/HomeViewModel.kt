package com.ovais.sadapaycasestudy.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ovais.sadapaycasestudy.R
import com.ovais.sadapaycasestudy.base.BaseViewModel
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.features.home.domain.GithubRepositoriesUseCase
import com.ovais.sadapaycasestudy.managers.StringResourceManager
import com.ovais.sadapaycasestudy.managers.ToastManager
import com.ovais.sadapaycasestudy.utils.ViewError
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val githubHomeUseCase: GithubRepositoriesUseCase,
    private val toastManager: ToastManager,
    private val stringResourceManager: StringResourceManager
) : BaseViewModel() {

    val shimmerState: LiveData<Boolean>
        get() = _shimmerState
    private val _shimmerState: MutableLiveData<Boolean> by lazy { MutableLiveData() }

    val errorViewVisibility: LiveData<Boolean>
        get() = _errorViewVisibility
    private val _errorViewVisibility: MutableLiveData<Boolean> by lazy { MutableLiveData() }

    val githubRepositoriesData: LiveData<List<GithubRepositoryUIData>>
        get() = _githubRepositoriesData
    private val _githubRepositoriesData: MutableLiveData<List<GithubRepositoryUIData>> by lazy { MutableLiveData() }

    fun onInitGithubRepositories() {
        fetchGithubRepositories()
    }

    private fun fetchGithubRepositories() {
        enableShimmerState()
        unzipResults(githubHomeUseCase(Unit), onSuccess = { response ->
            _githubRepositoriesData.value = response as List<GithubRepositoryUIData>
            _errorViewVisibility.value = false
            disableShimmerState()
        }, onError = { error ->
            _errorViewVisibility.value = true
            toastManager.showToast((error as ViewError).message)
            disableShimmerState()
        })
    }

    fun onRetry() {
        fetchGithubRepositories()
    }

    fun onItemSelected(item: GithubRepositoryUIData) {
        toastManager.showToast(
            stringResourceManager.getString(
                R.string.item_tapped_message,
                item.repositoryName,
                item.ownerName
            )
        )
    }

    private fun enableShimmerState() {
        _shimmerState.value = true
    }

    private fun disableShimmerState() {
        _shimmerState.value = false
    }
}