package com.example.nutriapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nutriapp.database.dao.UsuarioDao
import com.example.nutriapp.database.entities.Alimento
import com.example.nutriapp.database.entities.Ref
import com.example.nutriapp.database.entities.Usuario

@Database(
    entities = [
        Alimento::class,
        Ref::class,
        Usuario::class
    ],
    version = 1)
abstract class NutriDatabase : RoomDatabase() {

    abstract val usuarioDao : UsuarioDao

    companion object{
        @Volatile
        private var INSTANCE : NutriDatabase? = null

        fun getInstance (context : Context): NutriDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NutriDatabase::class.java,
                    "nutri_db").build().also {
                        INSTANCE = it
                }
            }
        }
    }
}