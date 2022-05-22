package com.asimodabas.crypto_tracking_v2.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asimodabas.crypto_tracking_v2.model.Crypto
import com.asimodabas.crypto_tracking_v2.util.Resource
import com.asimodabas.crypto_tracking_v2.viewmodel.CryptoDetailsViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CryptoDetailScreen(
    id: String,
    price: String,
    navController: NavController,
    viewModel:CryptoDetailsViewModel = hiltViewModel()
) {

    // -> 1
    val scope = rememberCoroutineScope()
    var cryptoItem by remember {
        mutableStateOf<Resource.Resource<Crypto>>(Resource.Resource.Loading())
    }
        scope.launch {
            cryptoItem = viewModel.getCrypto(id)
            println(cryptoItem.data)
        }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.Center){
        
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            when(cryptoItem){

                is Resource.Resource.Success -> {


                }
                is Resource.Resource.Error -> {


                }
                is Resource.Resource.Loading -> {


                }
            }
        }
    }


}