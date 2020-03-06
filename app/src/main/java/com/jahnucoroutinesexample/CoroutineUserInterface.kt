package com.jahnucoroutinesexample

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface CoroutineUserInterface {
    @GET("repos/square/retrofit/commits")
    suspend fun getGithubData(): List<GithubData>
}