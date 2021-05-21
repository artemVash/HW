package by.vashkevich.lesson1hw.HW8.mappers.cryptocurrency

import by.vashkevich.lesson1hw.HW8.data.dto.cryptocurrency.CryptoLogoResponse
import by.vashkevich.lesson1hw.HW8.data.dto.cryptocurrency.CryptoRateResponseTest
import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoLogo
import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoRate
import by.vashkevich.lesson1hw.HW8.mappers.Mapper

class CryptoRateResponseMapper : Mapper<CryptoRateResponseTest.Data?,CryptoRate,CryptoLogoResponse,CryptoLogo> {

    override fun map(
        from: CryptoRateResponseTest.Data?
    ): CryptoRate {

        return CryptoRate(
            id = from?.id ?:0,
            name = from?.name.orEmpty(),
            symbol = from?.symbol.orEmpty(),
            lastUpdated = from?.quote?.uSD?.lastUpdated.orEmpty(),
            percentChange1h = from?.quote?.uSD?.percentChange1h ?: 0.0,
            price = from?.quote?.uSD?.price ?: 0.0,
        )
    }

    override fun mapLogo(from: CryptoLogoResponse): CryptoLogo {
         return CryptoLogo(
             id = from.data?.x1?.id ?:0,
             logo = from.data?.x1?.logo.orEmpty()
         )
    }
}