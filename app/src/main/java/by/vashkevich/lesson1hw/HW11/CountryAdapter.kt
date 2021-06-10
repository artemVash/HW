package by.vashkevich.lesson1hw.HW11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.HW11.data.entity.CountryWithHoliday
import by.vashkevich.lesson1hw.R

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    private var list = ArrayList<CountryWithHoliday>()

    fun init(newList : ArrayList<CountryWithHoliday>){
        list = newList
        notifyDataSetChanged()
    }

    fun updateItem(item: CountryWithHoliday?){
        val oldItem = list.find {
            it.code == item?.code
        }

        val oldItemIndex = list.indexOf(oldItem)

        if(item != null){
            list[oldItemIndex] = item
        }

        notifyDataSetChanged()
    }

    fun getCountryHolidayList() = list

    inner class ViewHolder(private val view: View):RecyclerView.ViewHolder(view){

        fun bind(item: CountryWithHoliday){

            view.findViewById<TextView>(R.id.country).text = item.countryName

            if (item.holidayName != null){
                view.findViewById<ProgressBar>(R.id.holiday_progress_bar).visibility = View.GONE
                view.findViewById<TextView>(R.id.holiday_country).text = item.holidayName
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_holiday_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}