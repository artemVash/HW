package by.vashkevich.lesson1hw.HW11.data.dto


import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("countries")
    val countries: List<Country?>?,
) {
    data class Country(
        @SerializedName("code")
        val code: String?,
        @SerializedName("name")
        val name: String?,
    )
}