package by.vashkevich.lesson1hw.HW7.database.dao

import androidx.room.*
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard

@Dao
interface CreditCardDao {

    @Insert
    suspend fun insert(card:CreditCard)

    @Delete
    suspend fun delete(card:CreditCard)

    @Update
    suspend fun update(card:CreditCard)

    @Query("SELECT * FROM credit_cards_table")
    suspend fun getAll() : List<CreditCard>

    @Query("DELETE FROM credit_cards_table")
    suspend fun clearAll()

    @Query("SELECT * FROM credit_cards_table WHERE payment_system == :payment")
    suspend fun getCardByPayment(payment:String): List<CreditCard>
}