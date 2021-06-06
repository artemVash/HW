package by.vashkevich.lesson1hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.HW11.CountryAdapter
import by.vashkevich.lesson1hw.HW11.data.entity.CountryWithHoliday
import by.vashkevich.lesson1hw.HW11.data.mapper.CountryResponseMapper
import by.vashkevich.lesson1hw.HW11.network.HolidayApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeWork11Activity : AppCompatActivity() {

    lateinit var disposables: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work11)

        val key = "953f5523-8c02-46df-b67b-26fdfe793f1e"
        val adapter = CountryAdapter()
        val holidayRecycler = findViewById<RecyclerView>(R.id.holiday_recycler)

        holidayRecycler.adapter = adapter


        disposables = CompositeDisposable()

        HolidayApi.providerRetrofit().getCountries(key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                val list = it.countries?.map {
                    CountryResponseMapper().map(it)
                }

                findViewById<ProgressBar>(R.id.country_progress_bar).visibility = View.GONE

                val listCountryWithHoliday = list?.map { coutries ->
                    CountryWithHoliday(
                        code = coutries.code,
                        countryName = coutries.name
                    )
                }

                adapter.init(listCountryWithHoliday as ArrayList<CountryWithHoliday>)

                Observable.fromIterable(listCountryWithHoliday).subscribeOn(Schedulers.io())
            }
            .subscribe({ countryWithHoliday ->
                HolidayApi.providerRetrofit().getHolidays(
                    key,
                    countryCode = countryWithHoliday.code.orEmpty(),
                    month = getMonth(),
                    day = getDay()
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        val oldList = adapter.getCountryHolidayList()
                        val oldCountryWithHoliday = oldList.find {
                            it.code == countryWithHoliday.code
                        }

                        oldCountryWithHoliday?.holidayName = it.holidays?.get(0)?.name.orEmpty()
                        adapter.updateItem(oldCountryWithHoliday)
                    },{})

            },{})

    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    private fun getMonth():Int{
        val time = Calendar.getInstance().timeInMillis
       return SimpleDateFormat("MM").format(Date(time)).toString().toInt()
    }

    private fun getDay():Int{
        val time = Calendar.getInstance().timeInMillis
        return SimpleDateFormat("dd").format(Date(time)).toString().toInt()
    }
}