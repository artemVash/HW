package by.vashkevich.lesson1hw.HW8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoLogo
import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoRate
import by.vashkevich.lesson1hw.HW8.repository.cryptocurrency.CryptoCurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ViewModelHW8 : ViewModel(){

    private val cryptoCurrencyRepository = CryptoCurrencyRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _cryptoRate = MutableLiveData<List<CryptoRate>>()
    val cryptoRate:LiveData<List<CryptoRate>> = _cryptoRate

    private val _cryptoLogo = MutableLiveData<CryptoLogo>()
    val cryptoLogo:LiveData<CryptoLogo> = _cryptoLogo

    private val _errorBus = MutableLiveData<String>()
    val errorBus : LiveData<String> = _errorBus

    private val _errorBusL = MutableLiveData<String>()
    val errorBusL : LiveData<String> = _errorBusL

    fun loadCryptoRate(key:String){
        ioScope.launch {
            try{
                _cryptoRate.postValue(cryptoCurrencyRepository.loadCryptoCurrency(key))
            }catch (e:Exception){
                _errorBus.postValue(e.message)
            }
        }
    }

    fun loadCryptoLogo(key:String,id:Int){
        ioScope.launch {
            try{
                _cryptoLogo.postValue(cryptoCurrencyRepository.loadLogo(key,id))
            }catch (e:Exception){
                _errorBusL.postValue(e.message)
            }
        }
    }

    fun getImage(id:Int):String{
        return when(id){
            1-> "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
            1027-> "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png"
            52-> "https://s2.coinmarketcap.com/static/img/coins/64x64/52.png"
            else -> "https://e7.pngegg.com/pngimages/65/309/png-clipart-bitcoin-com-cryptocurrency-logo-zazzle-bitcoin-text-trademark.png"
        }

    }
}