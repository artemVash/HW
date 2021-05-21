package by.vashkevich.lesson1hw.HW8.networking.cryptocurrency

import by.vashkevich.lesson1hw.BuildConfig
import by.vashkevich.lesson1hw.HW8.networking.CryptoCurrencyService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object CryptoCurrencyApi {

    fun providerRetrofit() :CryptoCurrencyService{

        val interceptor = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG)
            level = HttpLoggingInterceptor.Level.BODY
        }


        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .client(client)
            .build()

        return retrofit.create()


    }
}