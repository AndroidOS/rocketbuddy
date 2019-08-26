package com.devtides.animals.model

import com.casa.azul.rocketboy.Mission
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MissionApi {

    @GET("latest")
    fun getMissions(): Single<Mission>
}