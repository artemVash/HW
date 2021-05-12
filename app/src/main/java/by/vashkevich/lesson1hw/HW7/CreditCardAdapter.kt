package by.vashkevich.lesson1hw.HW7

import HW5.UserPageActivity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard
import by.vashkevich.lesson1hw.R
import by.vashkevich.lesson1hw.TAG
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class CreditCardAdapter(val list:List<CreditCard>,val viewModelHW7: ViewModelHW7,context: Context) : RecyclerView.Adapter<CreditCardAdapter.CardViewHolder>() {

    val contextR = context

   inner class CardViewHolder(private val view: View):RecyclerView.ViewHolder(view){

        fun setData(itemView:View,position: Int){

            val card = list[position]



            itemView.findViewById<TextView>(R.id.info_card_num).text = card.creditCardNumber.toString()
            itemView.findViewById<ImageView>(R.id.info_image_credit_card).setImageResource(card.image)
            itemView.findViewById<TextView>(R.id.info_valid_month).text = card.creditCardValidMonth.toString()
            itemView.findViewById<TextView>(R.id.info_valid_year).text = card.creditCardValidYear.toString()
            itemView.findViewById<TextView>(R.id.info_cardholder_name).text = card.cardHolder
            itemView.findViewById<ConstraintLayout>(R.id.item_container_credit_card).setOnClickListener {

                MaterialAlertDialogBuilder(contextR)

                    .setNegativeButton("back") { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton("delete") { dialog, which ->
                        viewModelHW7.delete(card)
                        viewModelHW7.getAll()
                    }
                    .show()

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_credit_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.setData(holder.itemView,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}