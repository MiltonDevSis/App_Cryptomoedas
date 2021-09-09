package com.example.cryptomoedas_app.data.repository

import com.example.cryptomoedas_app.data.remote.CoinPaprikaApi
import com.example.cryptomoedas_app.data.remote.dto.CoinDetailDto
import com.example.cryptomoedas_app.data.remote.dto.CoinDto
import com.example.cryptomoedas_app.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinsById(coinId)
    }
}