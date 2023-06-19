package com.daniel.data.di

import com.daniel.data.datasource.TopHeadlinesRemoteDataSource
import com.daniel.data.datasource.TopHeadlinesRemoteDataSourceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


val dataModule = module {
    factory<TopHeadlinesRemoteDataSource> {
        TopHeadlinesRemoteDataSourceImpl(
            client = get(
                named(
                    RETROFIT
                )
            )
        )
    }
}