package com.daniel.data.datasource

import com.daniel.core.BuildConfig
import com.daniel.data.model.NewsHeadlinesResponse
import com.daniel.data.services.NewsApiService
import retrofit2.Response
import retrofit2.Retrofit


class TopHeadlinesRemoteDataSourceImpl(private val client: Retrofit) :
    TopHeadlinesRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<NewsHeadlinesResponse> =
        client.create(NewsApiService::class.java)
            .getHeadlines(
                apiKey = BuildConfig.NEWS_API_KEY,
                countryCode = "gb",
                category = "general"
            )


}