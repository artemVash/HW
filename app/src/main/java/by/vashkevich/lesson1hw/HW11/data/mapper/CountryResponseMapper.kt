package by.vashkevich.lesson1hw.HW11.data.mapper

import by.vashkevich.lesson1hw.HW11.data.dto.CountriesResponse
import by.vashkevich.lesson1hw.HW11.data.entity.Countries

class CountryResponseMapper : Mapper<CountriesResponse.Country?,Countries> {
    override fun map(from: CountriesResponse.Country?): Countries {
        return Countries(
            code = from?.code.orEmpty(),
            name = from?.name.orEmpty()
        )
    }


}