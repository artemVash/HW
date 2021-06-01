package by.vashkevich.lesson1hw.HW9.mappers

import by.vashkevich.lesson1hw.HW9.data.dto.AdviceResponse
import by.vashkevich.lesson1hw.HW9.data.entities.Advice

class AdviceResponseMapper : MapperAdvice<AdviceResponse?,Advice> {
    override fun map(
        from: AdviceResponse?
    ): Advice {
        return Advice(
            id = from?.slip?.id ?:0,
            advice = from?.slip?.advice.orEmpty()
        )

    }
}