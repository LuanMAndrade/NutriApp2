package com.example.nutriapp.navigation

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.nutriapp.database.entities.Usuario
import com.example.nutriapp.ui.activity.R
import com.example.nutriapp.ui.activity.ui.theme.NutriAppTheme
import com.example.nutriapp.ui.objects.CircularProgressBar





@Composable
fun Login(navController: NavController, autenticar : (login : String, senha : String) -> Unit) {

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

        Button(onClick = { (autenticar(text1,text2))
            dataStore.data.collect { preferences ->
                preferences[stringPreferencesKey("usuarioLogado")]?.let { usuarioId ->
                    navController.navigate(Screens.CadastroUsuario.route)
                    }}

        }) {
            Text(text = "Entrar")
        }
        Button(onClick = { navController.navigate(Screens.CadastroUsuario.route) }) {
            Text(text = "Cadastrar")
        }

    }

}

@Composable
fun CadastroUsuario(navController: NavController, salvar: (Usuario) -> Unit) {


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
            val usuarioNovo = Usuario(login, nome, senha)
            salvar(usuarioNovo)
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
fun EditRef(salvar : (Usuario) -> Unit) {

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

        FloatingActionButton(onClick = { val usuarioNovo = Usuario( text1, text2, text3)
        salvar(usuarioNovo)}) {

        }

    }
}

@Composable
fun MessageCard (texto : String){
    NutriAppTheme() {
        Surface(Modifier.fillMaxSize()) {

            Row(Modifier.padding(8.dp)) {

                Image(painter = painterResource(id = R.drawable.profile_picture),
                    contentDescription ="picture",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                )

                Spacer(modifier = Modifier.width(10.dp))

                var expanded by remember {
                    mutableStateOf(false)
                }
                Column(Modifier.clickable { expanded = !expanded }) {
                    Text(text = "Luiza", color = MaterialTheme.colors.secondaryVariant)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = texto, maxLines = if (expanded) Int.MAX_VALUE else 1 )
                }
            }
        }
    }
}

@Composable
fun ListaMensagens(mensagens : List<String>){
    LazyColumn {
        items(mensagens){ mensagem ->
            MessageCard(texto = mensagem)
        }
    }
}