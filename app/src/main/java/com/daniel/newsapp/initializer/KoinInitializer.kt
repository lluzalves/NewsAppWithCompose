package com.daniel.newsapp.initializer

import android.content.Context
import androidx.startup.Initializer
import com.daniel.newsapp.di.KoinDependencyGraph
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
       return startKoin {
            androidLogger()
            androidContext(context)
            modules(KoinDependencyGraph().getNewsAppKoinDependencyModules())
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}