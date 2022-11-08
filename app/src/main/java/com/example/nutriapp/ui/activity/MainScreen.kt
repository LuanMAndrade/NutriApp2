package com.example.nutriapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.nutriapp.database.AppDatabase
import com.example.nutriapp.database.entities.Usuario
import com.example.nutriapp.navigation.EditRef
import com.example.nutriapp.navigation.Login
import com.example.nutriapp.navigation.Navigate
import com.example.nutriapp.navigation.Screens
import com.example.nutriapp.preferences.dataStore
import com.example.nutriapp.ui.activity.ui.theme.NutriAppTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private val usuarioDao by lazy {
        AppDatabase.INSTANCE(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NutriAppTheme {
                Surface(Modifier.fillMaxSize()) {
                    Navigate(
                        salvar = {
                            lifecycleScope.launch { launch { usuarioDao.insert(it) } }
                        },
                        autenticar = { login, senha ->
                            lifecycleScope.launch {
                                usuarioDao.autentica(login, senha)?.let { usuario ->
                                    dataStore.edit { preferences ->
                                        preferences[stringPreferencesKey("usuarioLogado")] =
                                            usuario.login
                                    }
                                }
                            }

                        })
                }
            }
        }
    }
}