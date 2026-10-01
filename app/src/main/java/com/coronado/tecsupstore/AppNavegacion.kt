package com.coronado.tecsupstore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavegacion() {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    var currentRoute by remember {
        mutableStateOf("inicio")
    }

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            AppDrawer(

                currentRoute = currentRoute,

                onNavigate = { route ->

                    currentRoute = route

                    scope.launch {
                        drawerState.close()
                    }
                }
            )
        }
    ) {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {
                        Text("TECSUP Store")
                    },

                    navigationIcon = {

                        IconButton(

                            onClick = {

                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {

                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú"
                            )
                        }
                    }
                )
            }

        ) { paddingValues ->

            ContenidoPantalla(
                route = currentRoute,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
fun ContenidoPantalla(
    route: String,
    modifier: Modifier = Modifier
) {

    when (route) {

        "inicio" -> {

            InicioScreen(
                modifier = modifier
            )
        }

        "pedidos" -> {

            PantallaSimple(
                titulo = "Mis pedidos",
                modifier = modifier
            )
        }

        "favoritos" -> {

            PantallaSimple(
                titulo = "Favoritos",
                modifier = modifier
            )
        }

        "perfil" -> {

            PantallaSimple(
                titulo = "Perfil",
                modifier = modifier
            )
        }

        "login" -> {

            PantallaSimple(
                titulo = "Sesión cerrada",
                modifier = modifier
            )
        }
    }
}

@Composable
fun InicioScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Más vendidos"
        )

        TarjetaProducto(
            nombre = "Audífonos",
            precio = "89.00"
        )

        TarjetaProducto(
            nombre = "Smartwatch",
            precio = "199.00"
        )

        TarjetaProducto(
            nombre = "Funda celular",
            precio = "25.00"
        )
    }
}

@Composable
fun PantallaSimple(
    titulo: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = titulo
        )
    }
}