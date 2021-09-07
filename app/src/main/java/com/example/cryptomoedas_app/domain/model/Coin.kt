package com.example.cryptomoedas_app.domain.model

import com.example.cryptomoedas_app.data.remote.dto.CoinDto
import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)

fun CoinDto.toCoin(): Coin{
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}