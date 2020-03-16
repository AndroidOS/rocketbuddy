package com.casa.azul.rocketboy.model

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface SpaceDao {

    @Insert
    suspend fun insertAll(vararg missions1: Mission1): List<Long>

    @androidx.room.Query("SELECT * FROM mission1")
    suspend fun getAllMissions(): List<Mission1>

    @androidx.room.Query("SELECT * FROM mission1 WHERE uuid = :missionId")
    suspend fun getMission(missionId: Int): Mission1

    @androidx.room.Query("DELETE FROM mission1")
    suspend fun deleteAllMissions()
}