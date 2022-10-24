package com.example.nutriapp.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.nutriapp.database.entities.Ref
import com.example.nutriapp.database.entities.Usuario

data class UsuarioWithRef(
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "login",
        entityColumn = "refName"
    )
    val refs : List<Ref>
)