package by.vashkevich.lesson1hw.HW7.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credit_cards_table")
data class CreditCard(
    @ColumnInfo(name = "card_number")
    val creditCardNumber:Long,
    @ColumnInfo(name = "month_valid")
    val creditCardValidMonth:Int,
    @ColumnInfo(name = "year_valid")
    val creditCardValidYear:Int,
    @ColumnInfo(name = "card_holder")
    val cardHolder:String,
    @ColumnInfo(name = "cvv")
    val cardCVV:Int,
    @ColumnInfo(name = "payment_system")
    val paymentSystem:String,
    val image:Int
) {
    @PrimaryKey(autoGenerate = true)
        var id:Int? = null

}