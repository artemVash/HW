package by.vashkevich.lesson1hw.HW11.network

import by.vashkevich.lesson1hw.HW11.data.dto.CountriesResponse
import by.vashkevich.lesson1hw.HW11.data.dto.HolidayResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HolidayService {

    @GET("v1/countries")
    fun getCountries(
        @Query("key")
        key:String,
    ):Observable<CountriesResponse>

    @GET("v1/holidays")
    fun getHolidays(
        @Query("key")
        key: String,
        @Query("country")
        countryCode: String,
        @Query("year")
        year: Int = 2020,
        @Query("month")
        month: Int,
        @Query("day")
        day: Int,
        @Query("upcoming")
        upcoming: Boolean = true
    ): Observable<HolidayResponse>
}