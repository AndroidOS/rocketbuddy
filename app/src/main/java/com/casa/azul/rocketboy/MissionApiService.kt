package com.casa.azul.rocketboy

import com.devtides.animals.model.MissionApi
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MissionApiService {

    private val BASE_URL = "https://api.spacexdata.com/v3/launches/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(MissionApi::class.java)

    fun getMission(): Single<Mission> {
        return api.getMissions()
    }
}