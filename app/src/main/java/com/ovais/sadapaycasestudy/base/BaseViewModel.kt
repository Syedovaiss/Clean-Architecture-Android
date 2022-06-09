package com.ovais.sadapaycasestudy.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ovais.sadapaycasestudy.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun unzipResults(
        flow: Flow<Resource<Any>>,
        onSuccess: (Any) -> Unit,
        onError: (Any) -> Unit
    ) {
        viewModelScope.launch {
            flow.collectLatest { resource ->
                when (resource) {
                    is Resource.Success -> onSuccess(resource.data)
                    is Resource.Error -> onError(resource.viewError)
                    else -> Unit
                }
            }
        }

    }
}