package by.vashkevich.lesson1hw.HW11.data.mapper

import by.vashkevich.lesson1hw.HW11.data.dto.HolidayResponse
import by.vashkevich.lesson1hw.HW11.data.entity.Holiday

class HolidayResponseMapper : Mapper<HolidayResponse.Holiday,Holiday> {
    override fun map(from: HolidayResponse.Holiday): Holiday {
        return Holiday(
            date = from.date.orEmpty(),
            name = from.name.orEmpty()
        )
    }
}