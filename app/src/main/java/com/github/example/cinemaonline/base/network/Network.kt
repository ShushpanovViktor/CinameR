package com.github.example.cinemaonline.base.network

import android.content.Context
import com.github.example.cinemaonline.base.network.interceptors.CacheControlInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun httpCache10Mb(context: Context): Cache = Cache(
    directory = context.cacheDir,
    maxSize = com.github.example.cinemaonline.base.constants.Constants.CACHE_SIZE_10_MB
)

fun okHttp(cache: Cache): OkHttpClient {
    return OkHttpClient.Builder()
        .cache(cache)
        .addNetworkInterceptor(CacheControlInterceptor())
        .addInterceptor(loggingInterceptor())
        .build()
}

private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
