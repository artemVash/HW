package HW5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeWork5ViewModel:ViewModel() {

    private var _name = MutableLiveData<String>("")
    val name : LiveData<String>
    get() = _name

    fun getName(nameUser:String){
        _name.value = nameUser
    }

}