package com.example.nutriapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nutriapp.database.AppDatabase
import com.example.nutriapp.database.entities.Usuario
import kotlinx.coroutines.launch



@Composable
fun Navigate(salvar : (Usuario) -> Unit, autenticar : (login: String, senha : String) -> Unit){
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
            EditRef(){
               salvar(it)
            }
        }
        composable(route = Screens.MainScreen.route){
            MainScreen(navController, context = LocalContext.current)
        }
        composable(route = Screens.Login.route){
            Login(navController){ login, senha ->
                autenticar(login, senha)
            }
        }
        composable(route = Screens.CadastroUsuario.route){
            CadastroUsuario(navController){
                salvar(it)
            }
        }
    }
}