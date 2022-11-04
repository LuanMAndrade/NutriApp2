package com.example.nutriapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import com.example.nutriapp.database.entities.Usuario

@Dao
interface UsuarioDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(usuario : Usuario)

}