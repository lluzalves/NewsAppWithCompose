package com.daniel.newsapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.DecelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import com.daniel.newsapp.presentation.ui.news.NewsScreen
import com.daniel.newsapp.presentation.ui.theme.NewsAppTheme
import com.daniel.newsapp.presentation.viewmodel.NewsHomeViewModel
import org.koin.android.ext.android.inject
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : ComponentActivity() {
    private val newsHomeViewModel: NewsHomeViewModel by inject()
    private var isContentLoaded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Content()
                }
            }
        }
        delayToLoadContent(timer = Timer(), duration = 3000)
        prepareSplashScreen(splashScreen = installSplashScreen())
    }

    private fun delayToLoadContent(timer: Timer, duration: Long) {
        timer.schedule(delay = duration) {
            isContentLoaded = true
        }
    }

    private fun prepareSplashScreen(splashScreen: SplashScreen) {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                return if (isContentLoaded) {
                    content.viewTreeObserver.removeOnPreDrawListener(this)
                    true
                } else false
            }
        })
        splashScreen.setOnExitAnimationListener(object :SplashScreen.OnExitAnimationListener{
            override fun onSplashScreenExit(splashScreenViewProvider: SplashScreenViewProvider) {
                val objectAnimator = buildObjectAnimation(splashScreenViewProvider)
                objectAnimator.start()
            }
        })
    }

    private fun buildObjectAnimation(splashScreenView: SplashScreenViewProvider): ObjectAnimator {
        return ObjectAnimator.ofFloat(
            splashScreenView.view,
            View.TRANSLATION_X,
            0f,
            -splashScreenView.view.width.toFloat()
        ).apply {
            interpolator = DecelerateInterpolator()
            duration = 800L
            doOnEnd { splashScreenView.remove() }
        }
    }

    @Composable
    fun Content() {
        NewsScreen(newsHomeViewModel = newsHomeViewModel)
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentPreview() {
        NewsAppTheme {
            Content()
        }
    }
}