package HW4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeWork4ViewModel:ViewModel() {

    var listM = MutableLiveData<ArrayList<SnowDrop>>()


    fun addList(list:ArrayList<SnowDrop>){
        listM.value = list
    }

   fun restart() {
    //listM = MutableLiveData<ArrayList<SnowDrop>>()
   }
}