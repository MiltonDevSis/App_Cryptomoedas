package com.example.cryptomoedas_app.presentation.coin_detail

import com.example.cryptomoedas_app.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
