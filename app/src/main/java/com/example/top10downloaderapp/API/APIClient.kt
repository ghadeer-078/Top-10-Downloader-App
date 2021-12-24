package com.example.top10downloaderapp.API

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


class APIClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        return retrofit
    }

}