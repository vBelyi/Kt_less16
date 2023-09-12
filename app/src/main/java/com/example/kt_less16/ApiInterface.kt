package com.example.kt_less16

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET ("/superhero-api/api/all.json")
    fun getRequest(): Observable<List<GetResponse>>
}