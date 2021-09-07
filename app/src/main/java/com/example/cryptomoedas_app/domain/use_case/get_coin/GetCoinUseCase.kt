package com.example.cryptomoedas_app.domain.use_case.get_coin

import com.example.cryptomoedas_app.common.Resource
import com.example.cryptomoedas_app.data.remote.dto.toCoinDetail
import com.example.cryptomoedas_app.domain.model.Coin
import com.example.cryptomoedas_app.domain.model.CoinDetail
import com.example.cryptomoedas_app.domain.model.toCoin
import com.example.cryptomoedas_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinsById(coinId).toCoinDetail()
            emit(Resource.Sucess(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Um erro inexperado aconteceu!"))
        }catch (e: IOException){
            emit(Resource.Error("Não foi possível achar o servidor, check sua internet"))
        }
    }
}