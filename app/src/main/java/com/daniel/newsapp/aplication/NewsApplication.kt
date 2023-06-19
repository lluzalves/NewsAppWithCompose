package com.daniel.newsapp.aplication

import android.app.Application
import android.os.StrictMode
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