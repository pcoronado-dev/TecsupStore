package com.coronado.tecsupstore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppNavegacion() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "TECSUP Store",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Más vendidos",
            style = MaterialTheme.typography.bodyMedium
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