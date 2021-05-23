package by.vashkevich.lesson1hw.HW9.repository

import by.vashkevich.lesson1hw.HW9.data.entities.Advice
import by.vashkevich.lesson1hw.HW9.mappers.AdviceResponseMapper
import by.vashkevich.lesson1hw.HW9.networking.AdviceApi

class AdviceRepository {

    private val api = AdviceApi.providerRetrofit()
    private val adviceMapper = AdviceResponseMapper()

    suspend fun loadRandomAdvice():Advice{
        val response = api.loadRandomAdvice()

        return if (response.isSuccessful){
            response.body().let {
                adviceMapper.map(it)
            }
        }else{
            throw Throwable(response.errorBody().toString())
        }
    }
}
