package by.vashkevich.lesson1hw.HW9.networking

import by.vashkevich.lesson1hw.BuildConfig
import com.google.gson.internal.bind.CollectionTypeAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object AdviceApi {

    fun providerRetrofit():AdviceService{

        val interceptor = HttpLoggingInterceptor().apply {
            if(BuildConfig.DEBUG)
                level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .client(client)
            .build()

        return retrofit.create()

    }
}