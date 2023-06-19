package com.daniel.newsapp.di

import com.daniel.core.di.concurrencyModule
import com.daniel.data.di.dataModule
import com.daniel.data.di.networkModule
import com.daniel.newsapp.di.ApplicationModules.domainModule
import com.daniel.newsapp.di.ApplicationModules.presentationModule
import org.koin.core.module.Module

class KoinDependencyGraph {

    fun getNewsAppKoinDependencyModules(): List<Module> {
        return listOf(
            networkModule,
            concurrencyModule,
            dataModule,
            domainModule,
            presentationModule
        )
    }
}