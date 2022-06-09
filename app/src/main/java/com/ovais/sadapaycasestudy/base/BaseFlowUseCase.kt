package com.ovais.sadapaycasestudy.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

interface BaseFlowUseCase<in P, R> {

    operator fun invoke(parameters: P): Flow<R> = execute(parameters).flowOn(dispatcher())
    fun execute(parameters: P): Flow<R>
    fun dispatcher(): CoroutineDispatcher = Dispatchers.IO
}