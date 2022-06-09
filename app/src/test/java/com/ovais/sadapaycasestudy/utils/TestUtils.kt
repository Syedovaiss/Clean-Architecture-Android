package com.ovais.sadapaycasestudy.utils

import kotlinx.coroutines.flow.*

suspend fun <T> Flow<T>.collectToList(take: Int): List<T> = take(take).toList()