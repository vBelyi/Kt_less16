package com.example.kt_less16

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET ("/superhero-api/api/all.json")
    fun getRequest(): Single<List<GetResponse>>
}