package by.vashkevich.lesson1hw.HW9

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.vashkevich.lesson1hw.HW9.data.entities.Advice
import by.vashkevich.lesson1hw.HW9.repository.AdviceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ViewModelHW9 : ViewModel() {

    private val adviceRepository = AdviceRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _advice = MutableLiveData<Advice>()
    val advice:LiveData<Advice> = _advice

    private val _errorAdvice = MutableLiveData<String>()
    val errorAdvice:LiveData<String> = _errorAdvice

    private val _timer = MutableLiveData<Int>()
    val timer : LiveData<Int> = _timer


    fun loadAdvice(){
        ioScope.launch {
            try {
                _advice.postValue(adviceRepository.loadRandomAdvice())
            }catch (e:Exception){
                _errorAdvice.postValue(e.message)
            }

        }

    }

    fun startTimer(){
        object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                _timer.value = p0.toInt().div(1000)
            }

            override fun onFinish() {
            }


        }.start()
    }




}