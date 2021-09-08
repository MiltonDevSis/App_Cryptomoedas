package com.example.cryptomoedas_app.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.example.cryptomoedas_app.domain.use_case.get_coins.GetCoinsUseCase
import javax.inject.Inject

class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel(){

}