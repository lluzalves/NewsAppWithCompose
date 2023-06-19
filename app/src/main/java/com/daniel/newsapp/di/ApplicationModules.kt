package com.daniel.newsapp.di

import com.daniel.data.repository.NewsRepositoryImp
import com.daniel.domain.NewsRepository
import com.daniel.domain.usecases.GetArticlesUseCaseImpl
import com.daniel.domain.usecases.GetArticlesUseCase
import com.daniel.newsapp.presentation.state.NewsHomeState
import com.daniel.newsapp.presentation.viewmodel.NewsHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object ApplicationModules {

    val domainModule = module {

        factory<NewsRepository> {
            NewsRepositoryImp(
                dataSource = get(), scope = get()
            )
        }

        factory<GetArticlesUseCase> { GetArticlesUseCaseImpl(repository = get()) }
    }


    val presentationModule = module {
        viewModel {
            NewsHomeViewModel(
                initialState = NewsHomeState.initialState,
                useCase = get(),
                coroutineScope = get()
            )
        }
    }
}
