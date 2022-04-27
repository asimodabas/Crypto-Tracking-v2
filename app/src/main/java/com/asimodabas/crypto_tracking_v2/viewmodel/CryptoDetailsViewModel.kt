package com.asimodabas.crypto_tracking_v2.viewmodel

import androidx.lifecycle.ViewModel
import com.asimodabas.crypto_tracking_v2.model.Crypto
import com.asimodabas.crypto_tracking_v2.repository.CryptoRepository
import com.asimodabas.crypto_tracking_v2.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailsViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String): Resource.Resource<Crypto> {
        return repository.getCrypto(id)
    }



}