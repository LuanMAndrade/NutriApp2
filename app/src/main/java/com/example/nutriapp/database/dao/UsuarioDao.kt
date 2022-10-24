package com.example.nutriapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nutriapp.database.entities.Usuario
import com.example.nutriapp.database.entities.relations.UsuarioWithRef

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insert(usuario: Usuario)

    @Query("SELECT * FROM Usuario WHERE usuarioId = :usuarioId")
    suspend fun searchById(usuarioId: String) : Usuario

    @Query("SELECT * FROM Usuario WHERE usuarioId = :usuarioId")
    suspend fun searchUsuarioWithRef(usuarioId: String) : List<UsuarioWithRef>




}