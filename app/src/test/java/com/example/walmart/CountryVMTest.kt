package com.example.walmart

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.walmart.model.CountryDB
import com.example.walmart.model.CountryDBItem
import com.example.walmart.model.Currency
import com.example.walmart.model.Language
import com.example.walmart.repository.Repository
import com.example.walmart.viewmodel.CountryVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CountryVMTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: Repository
    lateinit var viewModel: CountryVM
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(dispatcher)
        viewModel = CountryVM(repository)
    }

    @Test
    fun fetchApi() = runTest {
        val content = CountryDB()
        content.add(
            CountryDBItem(
                "",
                "",
                Currency("", "", ""),
                "",
                "",
                Language("", "", "", ""),
                "",
                ""
            )
        )
        Mockito.`when`(repository.getCountries()).thenReturn(content)
        dispatcher.scheduler.advanceUntilIdle()
        val repo = viewModel.countriesLiveData.value
        assertEquals(repo, content)
    }

    @After
    fun close() {
        Dispatchers.shutdown()
    }

}