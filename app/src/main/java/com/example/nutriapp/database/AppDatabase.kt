package com.example.nutriapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nutriapp.database.dao.UsuarioDao
import com.example.nutriapp.database.entities.Usuario


@Database(
    entities = [Usuario::class],
    version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao() : UsuarioDao

    companion object{

        @Volatile
        private var db : AppDatabase? = null
        fun INSTANCE(context : Context) : AppDatabase{
            return db?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "nutriapp.db")
                .build()
                .also { db = it }
        }

    }



}