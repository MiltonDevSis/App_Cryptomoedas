package com.example.cryptomoedas_app.domain.use_case.get_coins

import com.example.cryptomoedas_app.common.Resource
import com.example.cryptomoedas_app.domain.model.Coin
import com.example.cryptomoedas_app.domain.model.toCoin
import com.example.cryptomoedas_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Sucess(coins))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Um erro inexperado aconteceu!"))
        }catch (e: IOException){
            emit(Resource.Error("Não foi possível achar o servidor, check sua internet"))
        }
    }
}