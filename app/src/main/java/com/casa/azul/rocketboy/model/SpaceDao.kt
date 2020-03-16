package com.casa.azul.rocketboy.model

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface SpaceDao {

    @Insert
    suspend fun insertAll(vararg missions: Mission): List<Long>

    @androidx.room.Query("SELECT * FROM missions")
    suspend fun getAllMissions(): List<Mission>

    @androidx.room.Query("SELECT * FROM missions WHERE uuid = :missionId")
    suspend fun getMission(missionId: Int): Mission

    @androidx.room.Query("DELETE FROM missions")
    suspend fun deleteAllMissions()
}