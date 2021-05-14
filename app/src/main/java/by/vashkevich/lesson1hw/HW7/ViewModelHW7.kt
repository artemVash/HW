package by.vashkevich.lesson1hw.HW7

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.vashkevich.lesson1hw.HW7.database.MyDatabase
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard
import by.vashkevich.lesson1hw.HW7.repository.CreditCardRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ViewModelHW7(application : Application) : AndroidViewModel(application) {

    private val cardRepository = CreditCardRepository(MyDatabase.getDatabase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _cardList = MutableLiveData<List<CreditCard>>()
    val cardList : LiveData<List<CreditCard>> = _cardList

    private val _cardPayment = MutableLiveData<List<CreditCard>>()
    val cardPayment : LiveData<List<CreditCard>> = _cardPayment


    fun insert(card: CreditCard){
        cardRepository.insert(card)
    }

    fun delete(card: CreditCard){
        cardRepository.delete(card)
    }

    fun getAll(){
        ioScope.launch {
            val cardList = cardRepository.getAll()
            _cardList.postValue(cardList)
        }
    }

    fun clearAll(){
        cardRepository.clearAll()
    }

    fun getCardByPayment(payment:String){
        ioScope.launch {
            val cardPayment = cardRepository.getCardByPayment(payment)
            _cardPayment.postValue(cardPayment)
        }
    }

}