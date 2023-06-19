package com.daniel.data.di

import android.content.Context
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import java.io.File


class NetworkModuleTest : KoinTest {
    @MockK
    private lateinit var context: Context

    @MockK
    private lateinit var file: File

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun checkNetworkModule() {
        setUp()
        every { context.cacheDir } returns file
        stopKoin()
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(context)
            modules(listOf(networkModule))
        }.checkModules()
    }

}