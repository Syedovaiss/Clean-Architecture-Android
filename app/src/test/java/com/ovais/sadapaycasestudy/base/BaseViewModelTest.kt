package com.ovais.sadapaycasestudy.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
abstract class BaseViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setupDispatchers() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDownDispatchers() {
        Dispatchers.resetMain()
    }

}