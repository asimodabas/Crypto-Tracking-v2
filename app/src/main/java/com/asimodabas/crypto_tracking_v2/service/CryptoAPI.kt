package com.asimodabas.crypto_tracking_v2.service

import com.asimodabas.crypto_tracking_v2.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {

    // https://raw.githubusercontent.com/asimodabas/Crypto-Tracking-v2/master/cryptolist.json
    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key: String
    ): CryptoList

    // https://raw.githubusercontent.com/asimodabas/Crypto-Tracking-v2/master/crypto.json
    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String,
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ): Unit

}