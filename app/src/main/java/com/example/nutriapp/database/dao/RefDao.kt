package com.example.nutriapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.nutriapp.database.entities.Alimento

@Dao
interface RefDao {

    @Insert
    suspend fun insert (alimento: Alimento)

}