package com.example.nutriapp.navigation

sealed class Screens(val route : String){

    object DietChose : Screens("diet_chose")

    object MacrosChose : Screens("chose_macros")

    object CaloriesChose : Screens("calories_macros")

    object EditRef : Screens("edit_ref")

    object MainScreen: Screens("main_screen")

    object Login: Screens("login")

    object CadastroUsuario: Screens("cadastro_usuario")

    fun withArgs(vararg args : String) : String{
        return buildString {
            append(route)
            append("/$args")
        }
    }
}