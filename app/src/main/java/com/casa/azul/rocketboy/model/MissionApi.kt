package com.devtides.animals.model

import com.casa.azul.rocketboy.model.Mission
import io.reactivex.Single
import retrofit2.http.GET

interface MissionApi {

    @GET("launches/")
    fun getMissions(): Single<List<Mission>>
}