package com.example.top10downloaderapp.API

import com.example.top10downloaderapp.Model.Feed
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {

    @GET("RSS/topfreeapplications/limit=10/xml")
    fun getData() : Call<Feed>?

    @GET("RSS/topfreeapplications/limit=10/xml")
    suspend fun getDataResponse() : Response<Feed>?

}