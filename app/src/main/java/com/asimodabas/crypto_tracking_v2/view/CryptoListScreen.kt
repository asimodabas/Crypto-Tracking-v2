package com.asimodabas.crypto_tracking_v2.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asimodabas.crypto_tracking_v2.viewmodel.CryptoListViewModel

@Composable
fun CryptoListScreen(
    navController: NavController,
    viewModel: CryptoListViewModel = hiltViewModel()
) {

    Surface(
        color = MaterialTheme.colors.error,
        modifier = Modifier.fillMaxSize()
    ) {

        Column { 
            Text("Crypto Tracking", modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            
            Spacer(modifier = Modifier.height(10.dp))
            //Search
            Spacer(modifier = Modifier.height(10.dp))
            //List
        }

    }

}

@Composable
fun SerachBar(
    modifier : Modifier = Modifier,
    hint : String = "",
    onSearch : (String) -> Unit = {}
){

    var text  by remember {
        mutableStateOf("")
    }
    BasicTextField(value = text, onValueChange = {
        text = it
        onSearch(it)
    })

}