package com.example.cryptomoedas_app.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptomoedas_app.common.Constants
import com.example.cryptomoedas_app.common.Resource
import com.example.cryptomoedas_app.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptomoedas_app.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptomoedas_app.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    stateStateHandle: SavedStateHandle
): ViewModel(){
    
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
       stateStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
           getCoin(coinId)
       }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Sucess -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Um erro inexperado aconteceu!")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}