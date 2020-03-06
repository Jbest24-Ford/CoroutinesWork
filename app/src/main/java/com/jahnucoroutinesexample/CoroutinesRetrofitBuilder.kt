package com.jahnucoroutinesexample

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object CoroutinesRetrofitBuilder {
    private const val BASE_URL = "https://api.github.com/"

    var client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoroutineUserInterface::class.java)
    suspend fun getData() = client.getGithubData()
}