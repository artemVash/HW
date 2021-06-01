package by.vashkevich.lesson1hw.HW9.networking

import by.vashkevich.lesson1hw.HW9.data.dto.AdviceResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceService {

    @GET("advice")
    suspend fun loadRandomAdvice(): Response<AdviceResponse>
}