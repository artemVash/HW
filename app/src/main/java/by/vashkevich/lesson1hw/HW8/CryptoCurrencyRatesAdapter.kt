package by.vashkevich.lesson1hw.HW8

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency.CryptoRate
import by.vashkevich.lesson1hw.R
import com.squareup.picasso.Picasso

class CryptoCurrencyRatesAdapter(val list:List<CryptoRate>,val context:Context,val viewModel:ViewModelHW8,val array:ArrayList<Int>) : RecyclerView.Adapter<CryptoCurrencyRatesAdapter.CryptoCurrencyHandler>() {

    inner class CryptoCurrencyHandler(private val view: View) : RecyclerView.ViewHolder(view){

        fun setData(itemView:View,position: Int){

            val crypto = list[position]

            itemView.findViewById<TextView>(R.id.name_crypto).text = crypto.name
            itemView.findViewById<TextView>(R.id.price_crypto).text = "$${Math.round(crypto.price * 100.0).div(100.0)}"
            itemView.findViewById<TextView>(R.id.percent_change_crypto).text =  "${Math.round(crypto.percentChange1h * 100.0).div(100.0)}%"

            if(crypto.percentChange1h < 0.0){
                itemView.findViewById<TextView>(R.id.percent_change_crypto).setTextColor(Color.parseColor("#C70930"))
            }else{
                itemView.findViewById<TextView>(R.id.percent_change_crypto).setTextColor(Color.parseColor("#20AD00"))
            }
            val image = itemView.findViewById<TextView>(R.id.image_crypto)
            image.text = crypto.name.first().toString()
            image.setBackgroundResource(array.random())

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyHandler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto_currency, parent, false)
        return CryptoCurrencyHandler(view)
    }

    override fun onBindViewHolder(holder: CryptoCurrencyHandler, position: Int) {
        holder.setData(holder.itemView,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}