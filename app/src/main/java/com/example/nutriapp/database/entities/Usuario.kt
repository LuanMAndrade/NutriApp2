package com.example.nutriapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario (
    @PrimaryKey(autoGenerate = false)
    val usuarioId: String,
    val nome: String,
    val senha : String,
        )