package by.vashkevich.lesson1hw.HW10

import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard

class Utils {

    fun validateCreditCard(
        creditCardNum : Long,
        creditCardValidMonth : Int,
        creditCardValidYear : Int,
        cardHolder : String,
        cardCVV : Int,
        listCreditCard : List<Long> = emptyList(),

    ) : Boolean{

        if(creditCardNum.toString().length < 16 ||
            creditCardValidMonth.toString().length > 2 ||
            creditCardValidYear.toString().length > 2 ||
                cardHolder.isEmpty() ||
                cardCVV != 3 ) return false

        if(listCreditCard.contains(creditCardNum)) return false

        return true

    }
}