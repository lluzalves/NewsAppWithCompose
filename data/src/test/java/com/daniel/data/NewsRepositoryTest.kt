package com.daniel.data

import com.daniel.data.CoroutineTestRule
import com.daniel.data.datasource.TopHeadlinesRemoteDataSource
import com.daniel.data.repository.NewsRepositoryImp
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class NewsRepositoryImpTest {

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    private val testDispatcher = StandardTestDispatcher()
    private val coroutineScope = TestScope(testDispatcher)

    private val dataSource = mockk<TopHeadlinesRemoteDataSource>(relaxed = true)
    private val repositoryImp = NewsRepositoryImp(dataSource, coroutineScope)

    @Test
    fun testFetchNews() {
        coroutineScope.runTest {
            repositoryImp.getNewsItems()
        }
        coVerify { dataSource.getTopHeadlines() }
    }

}