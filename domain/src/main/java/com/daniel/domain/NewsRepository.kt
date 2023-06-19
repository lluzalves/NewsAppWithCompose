package com.daniel.domain

import com.daniel.domain.entity.ArticleItems


interface NewsRepository {
    suspend fun getNewsItems(): Result<ArticleItems>
}