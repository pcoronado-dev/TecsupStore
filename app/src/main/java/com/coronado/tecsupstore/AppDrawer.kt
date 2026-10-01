package com.coronado.tecsupstore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val Morado = Color(0xFF673AB7)
private val MoradoClaro = Color(0xFFEDE7F6)

@Composable
fun AppDrawer(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {

    ModalDrawerSheet(
        drawerContainerColor = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 24.dp
                )
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MoradoClaro),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "MR",
                        color = Morado,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.size(14.dp)
                )

                Column {

                    Text(
                        text = "Maria Rojas",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF28242B)
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "maria@tecsup.edu.pe",
                        color = Color.Gray
                    )
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        NavigationDrawerItem(

            label = {
                Text("Inicio")
            },

            selected = currentRoute == "inicio",

            onClick = {
                onNavigate("inicio")
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },

            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MoradoClaro,
                selectedIconColor = Morado,
                selectedTextColor = Morado
            ),

            modifier = Modifier.padding(
                horizontal = 12.dp
            )
        )

        NavigationDrawerItem(

            label = {
                Text(
                    text = "Mis pedidos",
                    fontWeight =
                        if (currentRoute == "pedidos")
                            FontWeight.Bold
                        else
                            FontWeight.Normal
                )
            },

            selected = currentRoute == "pedidos",

            onClick = {
                onNavigate("pedidos")
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = null
                )
            },

            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MoradoClaro,
                selectedIconColor = Morado,
                selectedTextColor = Morado
            ),

            modifier = Modifier.padding(
                horizontal = 12.dp
            )
        )

        NavigationDrawerItem(

            label = {
                Text("Favoritos")
            },

            selected = currentRoute == "favoritos",

            onClick = {
                onNavigate("favoritos")
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null
                )
            },

            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MoradoClaro,
                selectedIconColor = Morado,
                selectedTextColor = Morado
            ),

            modifier = Modifier.padding(
                horizontal = 12.dp
            )
        )

        NavigationDrawerItem(

            label = {
                Text("Perfil")
            },

            selected = currentRoute == "perfil",

            onClick = {
                onNavigate("perfil")
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },

            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MoradoClaro,
                selectedIconColor = Morado,
                selectedTextColor = Morado
            ),

            modifier = Modifier.padding(
                horizontal = 12.dp
            )
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        NavigationDrawerItem(

            label = {
                Text("Cerrar sesión")
            },

            selected = false,

            onClick = {
                onNavigate("login")
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = null
                )
            },

            modifier = Modifier.padding(
                horizontal = 12.dp
            )
        )
    }
}