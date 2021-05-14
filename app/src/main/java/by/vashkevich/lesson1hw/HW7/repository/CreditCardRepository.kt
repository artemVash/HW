package by.vashkevich.lesson1hw.HW7.repository

import by.vashkevich.lesson1hw.HW7.database.MyDatabase
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CreditCardRepository(

    database: MyDatabase
) {

    private val dao = database.creditCardDao()
    private val isScope = CoroutineScope(Dispatchers.IO)

    fun insert(card:CreditCard){

        isScope.launch {
            dao.insert(card)
        }
    }

    fun delete(card:CreditCard){

        isScope.launch {
            dao.delete(card)
        }
    }

    fun update(card:CreditCard){

        isScope.launch {
            dao.update(card)
        }
    }

    suspend  fun getAll():List<CreditCard>{
        return isScope.async {
            dao.getAll()
        }.await()

    }

    fun clearAll(){
        isScope.launch {
            dao.clearAll()
        }
    }

    suspend fun getCardByPayment(payment:String):List<CreditCard>{
        return isScope.async {
            dao.getCardByPayment(payment)
        }.await()
    }

}