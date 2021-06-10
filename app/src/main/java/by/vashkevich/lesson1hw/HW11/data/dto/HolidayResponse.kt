package by.vashkevich.lesson1hw.HW11.data.dto

import com.google.gson.annotations.SerializedName

data class HolidayResponse(
    @SerializedName("holidays")
    val holidays: List<Holiday?>?,
) {
    data class Holiday(
        @SerializedName("date")
        val date: String?,
        @SerializedName("name")
        val name: String?
    )
}