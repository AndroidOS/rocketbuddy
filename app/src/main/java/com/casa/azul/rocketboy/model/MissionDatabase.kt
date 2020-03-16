package com.casa.azul.rocketboy.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Mission1::class), version = 1)
abstract class MissionDatabase : RoomDatabase() {
    abstract fun missionDao(): SpaceDao

    companion object {
        @Volatile
        private var instance: MissionDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MissionDatabase::class.java,
            "missiondatabase"
        ).build()
    }
}