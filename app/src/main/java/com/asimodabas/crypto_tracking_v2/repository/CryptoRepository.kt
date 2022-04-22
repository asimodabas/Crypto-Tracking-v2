package com.asimodabas.crypto_tracking_v2.repository

import com.asimodabas.crypto_tracking_v2.model.Crypto
import com.asimodabas.crypto_tracking_v2.model.CryptoList
import com.asimodabas.crypto_tracking_v2.service.CryptoAPI
import com.asimodabas.crypto_tracking_v2.util.Constants.API_KEY
import com.asimodabas.crypto_tracking_v2.util.Constants.CALL_ATTRIBUTES
import com.asimodabas.crypto_tracking_v2.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
) {
    suspend fun getCryptoList():Resource.Resource<CryptoList>{
        val response =try{
            api.getCryptoList(API_KEY)
        } catch (e: Exception){
            return Resource.Resource.Error("Error.")
        }
        return Resource.Resource.Success(response)
    }

    suspend fun getCrypto(id:String) : Resource.Resource<Crypto>{
        val response = try {
api.getCrypto(API_KEY,id, CALL_ATTRIBUTES)
        }catch (e: Exception){
            return Resource.Resource.Error("Error.")

        }
        return Resource.Resource.Success(response)
    }


}