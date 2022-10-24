package com.example.nutriapp.navigation

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.nutriapp.database.NutriDatabase
import com.example.nutriapp.database.entities.Usuario
import com.example.nutriapp.ui.objects.CircularProgressBar
import kotlinx.coroutines.launch

@Composable
fun Login(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text1 by remember {
            mutableStateOf("login")
        }
        var text2 by remember {
            mutableStateOf("senha")
        }

        TextField(value = text1, onValueChange = { text1 = it })
        TextField(value = text2, onValueChange = { text2 = it })
        Button(onClick = { navController.navigate(Screens.DietChose.route) }) {
            Text(text = "Entrar")

        }
        Button(onClick = { navController.navigate(Screens.CadastroUsuario.route) }) {
            Text(text = "Cadastrar")
        }

    }

}

@Composable
fun CadastroUsuario(context: Context,navController: NavController) {

    val usuarioDao by lazy {
        NutriDatabase.getInstance(context).usuarioDao
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var login by remember {
            mutableStateOf("login")
        }
        var nome by remember {
            mutableStateOf("nome")
        }
        var senha by remember {
            mutableStateOf("senha")
        }

        TextField(value = login, onValueChange = { login = it })
        TextField(value = nome, onValueChange = { nome = it })
        TextField(value = senha, onValueChange = { senha = it })
        Button(onClick = {
            val usuarioNovo = Usuario(
                login,
                nome,
                senha)
            lifecycleScope
//                .launch { usuarioDao.insert(usuarioNovo) }

            navController.navigate(Screens.Login.route) }) {
            Text(text = "Salvar")
        }
    }
}


@Composable
fun DietChose(navController: NavController) {

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Escolha sua opção de dieta",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(modifier = Modifier.width(140.dp),
            onClick = { navController.navigate(Screens.MacrosChose.route) }) {
            Text(text = "Macros")
        }
        Spacer(modifier = Modifier.height(60.dp))

        Button(modifier = Modifier.width(140.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Dieta Feita")
        }
        Spacer(modifier = Modifier.height(60.dp))

        Button(modifier = Modifier.width(140.dp),
            onClick = { navController.navigate(Screens.CaloriesChose.route) }) {
            Text(text = "Calorias")
        }

    }

}

@Composable
fun MacrosChose(context: Context, navController: NavController) {
//    val database by lazy { NutriDatabase.getInstance(context).usuarioDao}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text1 by remember {
            mutableStateOf("")
        }
        var text2 by remember {
            mutableStateOf("")
        }
        var text3 by remember {
            mutableStateOf("")
        }
        Text(
            text = "Carboidratos",
            fontSize = 25.sp
        )
        TextField(value = text1, onValueChange = { text1 = it })
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Proteínas",
            fontSize = 25.sp
        )
        TextField(value = text2, onValueChange = { text2 = it })
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Gordura",
            fontSize = 25.sp
        )
        TextField(value = text3, onValueChange = { text3 = it })

    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        FloatingActionButton(onClick = { navController.navigate(Screens.MainScreen.route) }) {
            Icon(imageVector = Icons.Default.Check, contentDescription = "Certo")

            Text(text = "fdsnflks")
        }

    }

}

@Composable
fun CaloriesChose(context: Context) {
//    val database by lazy { NutriDatabase.getInstance(context).usuarioDao}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text1 by remember {
            mutableStateOf("")
        }

        Text(
            text = "Calorias",
            fontSize = 25.sp
        )
        TextField(value = text1, onValueChange = { text1 = it })
        Spacer(modifier = Modifier.height(40.dp))


    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        FloatingActionButton(onClick = { /*TODO*/ }) {
//            Icon(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Certo")

            Text(text = "fdsnflks")
        }

    }

}


@Composable
fun MainScreen(navController: NavController, context: Context) {
//    val database by lazy { NutriDatabase.getInstance(context).usuarioDao}


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val (box, fab, lazyColumn) = createRefs()
            val teste = 10
            val visibility by remember {
                mutableStateOf(true)
            }


            Box(
                modifier = Modifier
                    .constrainAs(box) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        height = Dimension.value(200.dp)
                        width = Dimension.matchParent
                    },
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Box(contentAlignment = Alignment.Center) {
                        LinearProgressIndicator(
                            progress = 0.8f,
                            color = Color.Green,
                            modifier = Modifier
                                .rotate(180f)
                                .height(30.dp)
                                .width(300.dp)
                        )
                        Text(text = "80/100\nCalorias", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CircularProgressBar(
                            modifier = Modifier,
                            done = 80f,
                            radius = 50f,
                            text = "Carboidratos"
                        )
                        CircularProgressBar(
                            modifier = Modifier,
                            done = 80f,
                            radius = 50f,
                            text = "Proteínas"
                        )
                        AnimatedVisibility(visible = visibility) {

                            CircularProgressBar(
                                modifier = Modifier,
                                done = 80f,
                                radius = 50f,
                                text = "Gorduras"
                            )
                        }

                    }
                }
            }
            Box(modifier = Modifier
                .constrainAs(lazyColumn) {
                    top.linkTo(box.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(fab.top)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints

                }) {

                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    val jorge = listOf("sdfmsçd", "asbkiba")

                    items(teste) {
                        var visibility2 by remember {
                            mutableStateOf(true)
                        }
                        Column(modifier = Modifier.fillMaxSize()) {
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                                    .clickable { visibility2 = !visibility2 }) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "Refeição $it")
                                    Icon(
                                        modifier = Modifier.clickable {
                                            navController.navigate(
                                                Screens.EditRef.route
                                            )
                                        },
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit"
                                    )
                                }
                            }
                            AnimatedVisibility(visible = visibility2) {
                                Column {
                                    (0..5).forEach {
                                        Text(text = "sfsd $it")
                                    }
                                }
                            }

                        }
                    }

                }
            }
            FloatingActionButton(modifier = Modifier
                .constrainAs(fab) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(lazyColumn.bottom)
                    bottom.linkTo(parent.bottom)
                }, onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )

            }

        }
    }
}

@Composable
fun EditRef(context: Context) {
//    val database by lazy { NutriDatabase.getInstance(context).usuarioDao}

    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }
    var text3 by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TextField(value = text1, onValueChange = { text1 = it })
        TextField(value = text2, onValueChange = { text2 = it })
        TextField(value = text3, onValueChange = { text3 = it })

        FloatingActionButton(onClick = { /*TODO*/ }) {

        }

    }
}