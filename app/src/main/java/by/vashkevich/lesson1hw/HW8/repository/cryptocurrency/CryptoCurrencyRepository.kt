package by.vashkevich.lesson1hw.HW8.repository.cryptocurrency

import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoLogo
import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoRate
import by.vashkevich.lesson1hw.HW8.mappers.cryptocurrency.CryptoRateResponseMapper
import by.vashkevich.lesson1hw.HW8.networking.cryptocurrency.CryptoCurrencyApi

class CryptoCurrencyRepository {

    private val api = CryptoCurrencyApi.providerRetrofit()
    private val cryptoRateResponseMapper = CryptoRateResponseMapper()

    suspend fun loadCryptoCurrency(key:String): List<CryptoRate> {
        val response = api.loadCryptoRates(key)

        return if (response.isSuccessful){
            response.body()?.data?.map {
                cryptoRateResponseMapper.map(it)
            }.orEmpty()
        }else{
            throw Throwable(response.errorBody().toString())
        }
    }

    suspend fun loadLogo(key:String,id:Int): CryptoLogo? {
        val response = api.loadLogo(id,key)

        return if (response.isSuccessful){
            response.body()?.let {
                cryptoRateResponseMapper.mapLogo(it)
            }
        }else{
            throw Throwable(response.errorBody().toString())
        }
    }

}