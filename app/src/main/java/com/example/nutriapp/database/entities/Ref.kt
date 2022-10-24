package com.example.nutriapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ref (
    @PrimaryKey(autoGenerate = false)
    val refName : String
        )