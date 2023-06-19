package com.daniel.newsapp.viewmodel

import com.daniel.domain.entity.ArticleItems
import com.daniel.domain.usecases.GetArticlesUseCase
import com.daniel.newsapp.presentation.state.NewsHomeState
import com.daniel.newsapp.presentation.viewmodel.NewsHomeViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Test

class NewsHomeViewModelTest {
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    private val useCase: GetArticlesUseCase = mockk(relaxed = true)
    private val state: NewsHomeState = mockk(relaxed = true)
    private val result: Result<ArticleItems> = mockk(relaxed = true)
    private lateinit var viewModel: NewsHomeViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val coroutineScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        viewModel = NewsHomeViewModel(state, useCase, coroutineScope = coroutineScope)
    }

    @Test
    fun should() {
        coEvery {
            useCase.getArticlesResult()
        } returns result

        viewModel.setState { NewsHomeState.initialState }

        coVerify {
            useCase.getArticlesResult()
        }
    }
}