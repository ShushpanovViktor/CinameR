package com.github.example.cinemaonline

import android.app.Application
import com.github.example.cinemaonline.di.appModule
import com.github.example.cinemaonline.di.navModule
import com.github.example.cinemaonline.di.videoPlayerModule
import com.github.example.cinemaonline.feature.movies_screen.di.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CinemaOnline : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@CinemaOnline)
            modules(
                appModule, navModule, moviesModule,
                videoPlayerModule
            )
        }
    }
}