package by.vashkevich.lesson1hw.HW11.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object HolidayApi {

    fun providerRetrofit():HolidayService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://holidayapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        return retrofit.create()
    }
}