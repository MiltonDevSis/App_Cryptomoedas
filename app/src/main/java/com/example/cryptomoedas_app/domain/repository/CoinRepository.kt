package com.example.cryptomoedas_app.domain.repository

import com.example.cryptomoedas_app.data.remote.dto.CoinDetailDto
import com.example.cryptomoedas_app.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinsById(coinId: String): CoinDetailDto
}