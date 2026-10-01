package com.coronado.tecsupstore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawer(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {

    ModalDrawerSheet {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEDE7F6)),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "MR",
                    color = Color(0xFF673AB7),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Maria Rojas",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "maria@tecsup.edu.pe",
                color = Color.Gray
            )
        }

        HorizontalDivider()

        Spacer(
            modifier = Modifier.height(12.dp)
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

            modifier = Modifier.padding(horizontal = 12.dp)
        )

        NavigationDrawerItem(

            label = {
                Text("Mis pedidos")
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

            modifier = Modifier.padding(horizontal = 12.dp)
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

            modifier = Modifier.padding(horizontal = 12.dp)
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

            modifier = Modifier.padding(horizontal = 12.dp)
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

            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}