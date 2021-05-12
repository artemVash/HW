package by.vashkevich.lesson1hw.HW7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.vashkevich.lesson1hw.HW7.database.dao.CreditCardDao
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard

@Database(entities = [CreditCard::class],version = 3)
abstract class MyDatabase : RoomDatabase() {

    abstract fun creditCardDao() : CreditCardDao

    companion object{
        var INSTANCE :MyDatabase? = null

        fun getDatabase(context:Context):MyDatabase{

            return if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context,MyDatabase::class.java,"database_second").build()
                INSTANCE as MyDatabase
            }else INSTANCE as MyDatabase
        }
    }
}