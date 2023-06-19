package com.daniel.domain.usecases

import com.daniel.domain.entity.ArticleItems

interface GetArticlesUseCase {
    suspend fun getArticlesResult() : Result<ArticleItems>
}