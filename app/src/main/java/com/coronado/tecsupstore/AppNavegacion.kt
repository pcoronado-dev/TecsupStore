package com.coronado.tecsupstore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private val MoradoPrincipal = Color(0xFF673AB7)
private val Fondo = Color(0xFFFFFFFF)

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

    var favoritos by remember {
        mutableStateOf(setOf<String>())
    }

    val agregarFavorito: (String) -> Unit = { producto ->
        if (!favoritos.contains(producto)) {
            favoritos = favoritos + producto
        }
    }

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            AppDrawer(
                currentRoute = currentRoute,
                favoritosCount = favoritos.size,

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

            containerColor = Fondo,

            topBar = {

                TopAppBar(

                    title = {

                        Column {

                            Text(
                                text = "TECSUP Store",
                                color = Color.White
                            )

                            Text(
                                text = "Más vendidos",
                                color = Color(0xFFD9CBEA)
                            )
                        }
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
                                contentDescription = "Abrir menú",
                                tint = Color.White
                            )
                        }
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MoradoPrincipal
                    )
                )
            }

        ) { paddingValues ->

            ContenidoPantalla(
                route = currentRoute,
                favoritos = favoritos,
                onAgregarFavorito = agregarFavorito,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
fun ContenidoPantalla(
    route: String,
    favoritos: Set<String>,
    onAgregarFavorito: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    when (route) {

        "inicio" -> {

            InicioScreen(
                favoritos = favoritos,
                onAgregarFavorito = onAgregarFavorito,
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
    favoritos: Set<String>,
    onAgregarFavorito: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        TarjetaProducto(
            nombre = "Audífonos",
            precio = "89.00",
            esFavorito = favoritos.contains("Audífonos"),
            onFavoritoClick = { onAgregarFavorito("Audífonos") }
        )

        TarjetaProducto(
            nombre = "Smartwatch",
            precio = "199.00",
            esFavorito = favoritos.contains("Smartwatch"),
            onFavoritoClick = { onAgregarFavorito("Smartwatch") }
        )

        TarjetaProducto(
            nombre = "Funda celular",
            precio = "25.00",
            esFavorito = favoritos.contains("Funda celular"),
            onFavoritoClick = { onAgregarFavorito("Funda celular") }
        )
    }
}

@Composable
fun PantallaSimple(
    titulo: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {

        Text(
            text = titulo
        )
    }
}
