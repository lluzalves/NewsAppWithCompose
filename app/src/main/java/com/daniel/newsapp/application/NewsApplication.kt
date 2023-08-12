package com.daniel.newsapp.application

import android.app.Application
import com.daniel.newsapp.di.KoinDependencyGraph
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NewsApplication)
            modules(KoinDependencyGraph().getNewsAppKoinDependencyModules())
        }

    }
}