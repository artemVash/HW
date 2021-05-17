package by.vashkevich.lesson1hw.HW8.networking

import by.vashkevich.lesson1hw.HW8.data.dto.cryptocurrency.CryptoLogoResponse
import by.vashkevich.lesson1hw.HW8.data.dto.cryptocurrency.CryptoRateResponseTest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CryptoCurrencyService {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun loadCryptoRates(
        @Header("X-CMC_PRO_API_KEY") apiKey:String
    ):Response<CryptoRateResponseTest>

    @GET("v1/cryptocurrency/info")
    suspend fun loadLogo(
        @Query("id") id:Int,
        @Header("X-CMC_PRO_API_KEY") apiKey:String
    ):Response<CryptoLogoResponse>
}