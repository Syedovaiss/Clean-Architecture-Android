package com.ovais.sadapaycasestudy.utils

import com.ovais.sadapaycasestudy.R
import com.ovais.sadapaycasestudy.base.BaseMapper
import com.ovais.sadapaycasestudy.managers.StringResourceManager
import com.ovais.sadapaycasestudy.utils.Constants.EMPTY_STRING
import java.lang.IllegalStateException
import javax.inject.Inject

interface ErrorStateMapper : BaseMapper<ResponseResult<Any>, Resource.Error>

class DefaultErrorStateMapper @Inject constructor(private val stringResourceManager: StringResourceManager) :
    ErrorStateMapper {

    override fun map(from: ResponseResult<Any>): Resource.Error {
        when (from) {
            is ResponseResult.Failure -> {
                val viewError = ViewError(
                    from.error.message ?: EMPTY_STRING,
                    from.error.errorCode ?: -1
                )
                return Resource.Error(viewError)
            }
            is ResponseResult.NetworkError -> {
                val viewError = ViewError(
                    stringResourceManager.getString(R.string.network_error_message),
                    -1
                )
                return Resource.Error(viewError)
            }
            else -> throw IllegalStateException(stringResourceManager.getString(R.string.invalid_error_state))
        }
    }
}