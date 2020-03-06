package com.jahnucoroutinesexample

import io.reactivex.Observable
import retrofit2.http.GET

interface UserService {
    @GET("repos/square/retrofit/commits")
    fun getGithubData(): Observable<List<GithubData>>
}