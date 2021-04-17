package HW3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeWork3ViewModel : ViewModel() {
    private val randomListDelay = listOf(1000L, 2000L, 3000L)
    private val randomList = listOf(10,20,30,40,50,60,70,80,90,100)

    //counter region 1
    var harvestCornRegion1 = MutableLiveData<Int>(0)
    var harvestPotatoRegion1 = MutableLiveData<Int>(0)
    var harvestCabbageRegion1 = MutableLiveData<Int>(0)
    var harvestBeetRegion1 = MutableLiveData<Int>(0)
    //counter region 2
    var harvestCornRegion2 = MutableLiveData<Int>(0)
    var harvestPotatoRegion2 = MutableLiveData<Int>(0)
    var harvestCabbageRegion2 = MutableLiveData<Int>(0)
    var harvestBeetRegion2 = MutableLiveData<Int>(0)
    //counter region 3
    var harvestCornRegion3 = MutableLiveData<Int>(0)
    var harvestPotatoRegion3 = MutableLiveData<Int>(0)
    var harvestCabbageRegion3 = MutableLiveData<Int>(0)
    var harvestBeetRegion3 = MutableLiveData<Int>(0)

    var regionControl = MutableLiveData<Int>(0)

    fun harvesting (){

        var a = true

        viewModelScope.launch {
            while (a) {
                delay(randomListDelay.random())
                if (compare(harvestCornRegion1,harvestPotatoRegion1,harvestCabbageRegion1,harvestBeetRegion1)){
                    a = false
                    regionControl.value = 1
                }else {
                    harvestCornRegion1.value = harvestCornRegion1.value?.toInt()?.plus(randomList.random())
                    harvestPotatoRegion1.value = harvestPotatoRegion1.value?.toInt()?.plus(randomList.random())
                    harvestCabbageRegion1.value = harvestCabbageRegion1.value?.toInt()?.plus(randomList.random())
                    harvestBeetRegion1.value = harvestBeetRegion1.value?.toInt()?.plus(randomList.random())
                }
            }
        }

        viewModelScope.launch {
            while (a) {
                delay(randomListDelay.random())
                if (compare(harvestCornRegion2,harvestPotatoRegion2,harvestCabbageRegion2,harvestBeetRegion2)){
                    a = false
                    regionControl.value = 2
                }else {
                    harvestCornRegion2.value = harvestCornRegion2.value?.toInt()?.plus(randomList.random())
                    harvestPotatoRegion2.value = harvestPotatoRegion2.value?.toInt()?.plus(randomList.random())
                    harvestCabbageRegion2.value = harvestCabbageRegion2.value?.toInt()?.plus(randomList.random())
                    harvestBeetRegion2.value = harvestBeetRegion2.value?.toInt()?.plus(randomList.random())
                }
            }
        }

        viewModelScope.launch {
            while (a) {
                delay(randomListDelay.random())
                if (compare(harvestCornRegion3,harvestPotatoRegion3,harvestCabbageRegion3,harvestBeetRegion3)){
                    a = false
                    regionControl.value = 3
                }else {
                    harvestCornRegion3.value = harvestCornRegion3.value?.toInt()?.plus(randomList.random())
                    harvestPotatoRegion3.value = harvestPotatoRegion3.value?.toInt()?.plus(randomList.random())
                    harvestCabbageRegion3.value = harvestCabbageRegion3.value?.toInt()?.plus(randomList.random())
                    harvestBeetRegion3.value = harvestBeetRegion3.value?.toInt()?.plus(randomList.random())
                }
            }
        }
    }

    private fun compare(corn:MutableLiveData<Int>, potato:MutableLiveData<Int>, cabbage:MutableLiveData<Int>, beet:MutableLiveData<Int>):Boolean{
        return corn.value?.toInt() ?: 1 > 1000 &&
                potato.value?.toInt() ?: 1 > 1000 &&
                cabbage.value?.toInt() ?: 1 > 1000 &&
                beet.value?.toInt() ?: 1 > 1000
    }


    fun restart(){
        harvestCornRegion1.value = 0
        harvestPotatoRegion1.value = 0
        harvestCabbageRegion1.value = 0
        harvestBeetRegion1.value = 0

        harvestCornRegion2.value = 0
        harvestPotatoRegion2.value = 0
        harvestCabbageRegion2.value = 0
        harvestBeetRegion2.value = 0

        harvestCornRegion3.value = 0
        harvestPotatoRegion3.value = 0
        harvestCabbageRegion3.value = 0
        harvestBeetRegion3.value = 0

        regionControl.value = 0
    }
}