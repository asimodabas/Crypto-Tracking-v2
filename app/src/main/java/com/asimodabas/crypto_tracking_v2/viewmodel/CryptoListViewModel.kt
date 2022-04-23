package com.asimodabas.crypto_tracking_v2.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asimodabas.crypto_tracking_v2.model.CryptoListItem
import com.asimodabas.crypto_tracking_v2.repository.CryptoRepository
import com.asimodabas.crypto_tracking_v2.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel(){

    var cryptoList = mutableStateOf<List<CryptoListItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun loadCryptos(){
        viewModelScope.launch {

            isLoading.value = true
            val result = repository.getCryptoList()
            when(result){

                is Resource.Resource.Success -> {

                }

                is Resource.Resource.Error -> {

                }

            }

        }
    }

}