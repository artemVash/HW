package by.vashkevich.lesson1hw.HW8.mappers

import by.vashkevich.lesson1hw.HW8.data.dto.cryptocurrency.CryptoRateResponseTest

interface Mapper<F,T,Y,X> {

    fun map(from: F): T

    fun mapLogo(from: Y):X
}