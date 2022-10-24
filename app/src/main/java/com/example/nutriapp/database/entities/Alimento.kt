package com.example.nutriapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alimento (
        @PrimaryKey(autoGenerate = false)
        val nome : String,
        val carboidrato: Float,
        val proteina: Float,
        val gordura: Float,
        val calorias : Int
        )