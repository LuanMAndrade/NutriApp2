package com.example.nutriapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.nutriapp.database.AppDatabase
import com.example.nutriapp.navigation.EditRef
import com.example.nutriapp.navigation.Navigate
import com.example.nutriapp.ui.activity.ui.theme.NutriAppTheme
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {

    private val usuarioDao by lazy {
        AppDatabase.INSTANCE(this).usuarioDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriAppTheme {
                Surface(Modifier.fillMaxSize()) {
                    EditRef{
                        lifecycleScope.launch {launch {   usuarioDao.insert(it)} }
                    }
                }
            }
        }
    }
}
