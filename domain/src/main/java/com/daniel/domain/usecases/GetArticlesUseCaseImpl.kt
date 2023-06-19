package com.daniel.domain.usecases

import com.daniel.domain.NewsRepository
import com.daniel.domain.entity.ArticleItems

class GetArticlesUseCaseImpl(private val repository: NewsRepository) : GetArticlesUseCase {
    override suspend fun getArticlesResult(): Result<ArticleItems> {
       return repository.getNewsItems()
    }
}