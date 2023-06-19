package com.daniel.data.datasource

import com.daniel.data.model.NewsHeadlinesResponse
import retrofit2.Response

interface TopHeadlinesRemoteDataSource {
    suspend fun getTopHeadlines(): Response<NewsHeadlinesResponse>
}