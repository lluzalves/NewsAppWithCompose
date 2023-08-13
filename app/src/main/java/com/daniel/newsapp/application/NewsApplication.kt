package com.daniel.newsapp.application

import android.app.Application
import com.daniel.newsapp.di.KoinDependencyGraph
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }
}