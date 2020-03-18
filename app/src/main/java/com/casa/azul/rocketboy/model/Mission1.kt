package com.casa.azul.rocketboy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mission1
    (
    val name: String?,
    val launch_date_utc: String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

