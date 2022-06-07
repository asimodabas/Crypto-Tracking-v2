package com.asimodabas.crypto_tracking_v2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.asimodabas.crypto_tracking_v2.model.Crypto
import com.asimodabas.crypto_tracking_v2.util.Resource
import com.asimodabas.crypto_tracking_v2.viewmodel.CryptoDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@Composable
fun CryptoDetailScreen(
    id:String,
    price:String,
    navController: NavController,
    viewModel: CryptoDetailsViewModel = hiltViewModel()
) {
/*
    // ------> 1
    val scope = rememberCoroutineScope()
    var cryptoItem by remember {
        mutableStateOf<Resource.Resource<Crypto>>(Resource.Resource.Loading())
    }

    scope.launch {
        cryptoItem = viewModel.getCrypto(id)
        println(cryptoItem.data)
    }
*/
/*
    // ------> 2
    var cryptoItem by remember {
        mutableStateOf<Resource.Resource<Crypto>>(Resource.Resource.Loading())
    }

    LaunchedEffect(key1 = Unit) {
        cryptoItem = viewModel.getCrypto(id)
        println(cryptoItem.data)
    }
*/
    // ------> 3
    val cryptoItem = produceState<Resource.Resource<Crypto>>(initialValue = Resource.Resource.Loading()) {
        value = viewModel.getCrypto(id)
    }.value


    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            when(cryptoItem) {

                is Resource.Resource.Success -> {
                    val selectedCrypto = cryptoItem.data!![0]
                    Text(text = selectedCrypto.name,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary,
                        textAlign = TextAlign.Center
                    )

                    Image(painter = rememberImagePainter(data = selectedCrypto.logo_url),
                        contentDescription = selectedCrypto.name,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(200.dp, 200.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )

                    Text(text = price,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center

                    )

                }

                is Resource.Resource.Error -> {
                    Text(cryptoItem.message!!)
                }

                is Resource.Resource.Loading -> {
                    CircularProgressIndicator(color = MaterialTheme.colors.primary)
                }

            }

        }
    }
}