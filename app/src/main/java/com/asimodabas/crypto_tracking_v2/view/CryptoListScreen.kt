package com.asimodabas.crypto_tracking_v2.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asimodabas.crypto_tracking_v2.viewmodel.CryptoListViewModel

@Composable
fun CryptoListScreen(navController: NavController,
viewModel:CryptoListViewModel = hiltViewModel()
) {

    Surface(
        color = MaterialTheme.colors.error, modifier = Modifier.fillMaxSize()
    ){

    }

}