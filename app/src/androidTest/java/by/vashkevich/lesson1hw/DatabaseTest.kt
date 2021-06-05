package by.vashkevich.lesson1hw

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import by.vashkevich.lesson1hw.HW10.Utils
import by.vashkevich.lesson1hw.HW7.database.MyDatabase
import by.vashkevich.lesson1hw.HW7.database.dao.CreditCardDao
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.manipulation.Ordering

class DatabaseTest {

    private lateinit var creditCardDao : CreditCardDao

    @Before
    fun init(){

        val context = ApplicationProvider.getApplicationContext<Context>()

        val db = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        creditCardDao = db.creditCardDao()
    }

    @Test
    fun insertCreditCard_returnTrue(){

        val creditCard = CreditCard(
            creditCardNumber = 4556765445674598,
            creditCardValidMonth = 2,
            creditCardValidYear = 23,
            cardHolder = "Artsiom",
            cardCVV = 555,
            paymentSystem = "visa",
            image = R.drawable.visa,
            id = 1
        )
        runBlocking {

            creditCardDao.insert(creditCard)

            val list = creditCardDao.getAll()

            Truth.assertThat(list.contains(creditCard)).isTrue()

        }
    }

    @Test
    fun deleteCreditCard_returnFalse(){

        val creditCard = CreditCard(
            creditCardNumber = 4556765445674598,
            creditCardValidMonth = 2,
            creditCardValidYear = 23,
            cardHolder = "Artsiom",
            cardCVV = 555,
            paymentSystem = "visa",
            image = R.drawable.visa,
            id = 1
        )

        val creditCard2 = CreditCard(
            creditCardNumber = 6436765445674598,
            creditCardValidMonth = 6,
            creditCardValidYear = 21,
            cardHolder = "Vasya",
            cardCVV = 656,
            paymentSystem = "master card",
            image = R.drawable.maestro,
            id = 2
        )

        runBlocking {

            creditCardDao.insert(creditCard)
            creditCardDao.insert(creditCard2)
            creditCardDao.delete(creditCard)

            val list = creditCardDao.getAll()

            Log.e("Tag",list.toString())

            Truth.assertThat(list.contains(creditCard)).isFalse()
        }
    }

    @Test
    fun clearAllCreditCard_returnTrue(){

        val creditCard = CreditCard(
            creditCardNumber = 4556765445674598,
            creditCardValidMonth = 2,
            creditCardValidYear = 23,
            cardHolder = "Artsiom",
            cardCVV = 555,
            paymentSystem = "visa",
            image = R.drawable.visa,
            id = 1
        )

        val creditCard2 = CreditCard(
            creditCardNumber = 6436765445674598,
            creditCardValidMonth = 6,
            creditCardValidYear = 21,
            cardHolder = "Vasya",
            cardCVV = 656,
            paymentSystem = "master card",
            image = R.drawable.master_card,
            id = 2
        )

        val creditCard3 = CreditCard(
            creditCardNumber = 7987765445674598,
            creditCardValidMonth = 7,
            creditCardValidYear = 22,
            cardHolder = "Petya",
            cardCVV = 333,
            paymentSystem = "maestro",
            image = R.drawable.maestro,
            id = 3
        )

        runBlocking {

            creditCardDao.insert(creditCard)
            creditCardDao.insert(creditCard2)
            creditCardDao.insert(creditCard3)
            creditCardDao.clearAll()

            val list = creditCardDao.getAll()

            Log.e("Tag",list.toString())

            Truth.assertThat(list.isEmpty()).isTrue()
        }
    }

    @Test
    fun getCreditCardByPayment_returnTrue(){

        val creditCard = CreditCard(
            creditCardNumber = 4556765445674598,
            creditCardValidMonth = 2,
            creditCardValidYear = 23,
            cardHolder = "Artsiom",
            cardCVV = 555,
            paymentSystem = "visa",
            image = R.drawable.visa,
            id = 1
        )

        val creditCard2 = CreditCard(
            creditCardNumber = 6436765445674598,
            creditCardValidMonth = 6,
            creditCardValidYear = 21,
            cardHolder = "Vasya",
            cardCVV = 656,
            paymentSystem = "master card",
            image = R.drawable.master_card,
            id = 2
        )

        val creditCard3 = CreditCard(
            creditCardNumber = 7987765445674598,
            creditCardValidMonth = 7,
            creditCardValidYear = 22,
            cardHolder = "Petya",
            cardCVV = 333,
            paymentSystem = "maestro",
            image = R.drawable.maestro,
            id = 3
        )

        runBlocking {

            creditCardDao.insert(creditCard)
            creditCardDao.insert(creditCard2)
            creditCardDao.insert(creditCard3)
            val check = creditCardDao.getCardByPayment(creditCard.paymentSystem)

            val list = creditCardDao.getAll()

            Log.e("Tag4",check.toString())

            Truth.assertThat(list.contains(creditCard2) || list.contains(creditCard3) ).isTrue()
        }
    }

    @Test
    fun validateCreditCardNumber_returnFalse(){

        val creditCard = CreditCard(
            creditCardNumber = 4556765445674598,
            creditCardValidMonth = 2,
            creditCardValidYear = 23,
            cardHolder = "Artsiom",
            cardCVV = 555,
            paymentSystem = "visa",
            image = R.drawable.visa,
            id = 1
        )

        val creditCard2 = CreditCard(
            creditCardNumber = 6436765445674598,
            creditCardValidMonth = 6,
            creditCardValidYear = 21,
            cardHolder = "Vasya",
            cardCVV = 656,
            paymentSystem = "master card",
            image = R.drawable.master_card,
            id = 2
        )

        val creditCard3 = CreditCard(
            creditCardNumber = 7987765445674598,
            creditCardValidMonth = 7,
            creditCardValidYear = 22,
            cardHolder = "Petya",
            cardCVV = 333,
            paymentSystem = "maestro",
            image = R.drawable.maestro,
            id = 3
        )

        runBlocking {

            creditCardDao.insert(creditCard)
            creditCardDao.insert(creditCard2)
            creditCardDao.insert(creditCard3)

            val utils = Utils()

            val result = utils.validateCreditCard(
                creditCardNum = 7987765445674598,
                creditCardValidMonth = 7,
                creditCardValidYear = 22,
                cardHolder = "Petya",
                cardCVV = 333,
                listCreditCard = creditCardDao.getAll().map {
                    it.creditCardNumber
                }
            )

            Truth.assertThat(result).isFalse()
        }
    }
}