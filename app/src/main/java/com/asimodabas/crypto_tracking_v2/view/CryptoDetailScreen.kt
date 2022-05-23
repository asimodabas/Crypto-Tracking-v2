package com.asimodabas.crypto_tracking_v2.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CryptoDetailScreen(
    id: String,
    price: String,
    navController: NavController,
    viewModel: CryptoDetailsViewModel = hiltViewModel()
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


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            when (cryptoItem) {

                is Resource.Resource.Success -> {

                    val selectedCrypto = cryptoItem.data!![0]
                    Text(
                        text = selectedCrypto.name,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary,
                        textAlign = TextAlign.Center
                    )

                    Image(
                        painter = rememberImagePainter(data =selectedCrypto.logo_url),
                        contentDescription =selectedCrypto.name,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(200.dp, 200.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )

                    Text(
                        text = price,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center
                    )

                }
                is Resource.Resource.Error -> {

                    Text(text = cryptoItem.message!!)

                }
                is Resource.Resource.Loading -> {

                    CircularProgressIndicator(color = MaterialTheme.colors.primary)
                }
            }
        }
    }


}