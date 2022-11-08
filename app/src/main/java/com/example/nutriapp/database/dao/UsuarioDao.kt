package com.example.nutriapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.nutriapp.database.entities.Usuario

@Dao
interface UsuarioDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(usuario : Usuario)

    @Query("SELECT * FROM Usuario WHERE login = :login AND senha = :senha")
    suspend fun autentica(login : String, senha : String) : Usuario?

}