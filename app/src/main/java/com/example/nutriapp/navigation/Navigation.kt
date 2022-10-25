package com.example.nutriapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigate(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route){
        composable(route = Screens.DietChose.route){
            DietChose(navController)
        }

        composable(route = Screens.MacrosChose.route){
            MacrosChose(context = LocalContext.current, navController)
        }
        composable(route = Screens.CaloriesChose.route){
            CaloriesChose(LocalContext.current)
        }
        composable(route = Screens.EditRef.route){
            EditRef(LocalContext.current)
        }
        composable(route = Screens.MainScreen.route){
            MainScreen(navController, context = LocalContext.current)
        }
        composable(route = Screens.Login.route){
            Login(navController)
        }
        composable(route = Screens.CadastroUsuario.route){
            CadastroUsuario(context = LocalContext.current,navController)
        }
        composable(route = Screens.Treino.route){
            Treino()
        }


    }
}