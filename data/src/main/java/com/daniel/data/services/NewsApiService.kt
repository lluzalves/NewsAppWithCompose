package com.daniel.data.services

import com.daniel.data.model.NewsHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") countryCode: String,
        @Query("category") category: String
    ): Response<NewsHeadlinesResponse>
}
