package com.coronado.tecsupstore

import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val Morado = Color(0xFF673AB7)
private val MoradoClaro = Color(0xFFEDE7F6)
private val FondoTarjeta = Color(0xFFF2EFF5)

@Composable
fun TarjetaProducto(
    nombre: String,
    precio: String,
    onFavoritoClick: () -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            )
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = FondoTarjeta
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Icono del producto
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(
                            color = MoradoClaro,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = null,
                        tint = Morado,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.size(12.dp)
                )

                // Nombre y precio
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = nombre,
                        color = Color(0xFF29252D)
                    )

                    Spacer(
                        modifier = Modifier.size(2.dp)
                    )

                    Text(
                        text = "S/ $precio",
                        color = Morado
                    )
                }

                // Botón de tres puntos
                IconButton(
                    onClick = {
                        expanded = true
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Más opciones",
                        tint = Color(0xFF555158)
                    )
                }
            }
        }

        // Menú contextual
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {

            DropdownMenuItem(

                text = {
                    Text("Favoritos")
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Morado
                    )
                },

                onClick = {
                    expanded = false
                    onFavoritoClick()
                }
            )

            HorizontalDivider()

            DropdownMenuItem(

                text = {
                    Text("Compartir")
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        tint = Morado
                    )
                },

                onClick = {
                    expanded = false
                }
            )

            HorizontalDivider()

            DropdownMenuItem(

                text = {
                    Text("Reportar")
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Flag,
                        contentDescription = null,
                        tint = Morado
                    )
                },

                onClick = {
                    expanded = false
                }
            )
        }
    }
}