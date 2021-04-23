package HW4

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.R
import com.squareup.picasso.Picasso

class MyAdapter(listArray:ArrayList<SnowDrop>,context: Context):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val nameInfo = view.findViewById<TextView>(R.id.info_name)
        val nameFlowerInfo= view.findViewById<TextView>(R.id.info_show_drop)
        val quantityInfo= view.findViewById<TextView>(R.id.info_quantity)
        val checkBoxPackagingInfo= view.findViewById<TextView>(R.id.info_packaging)
        val priceInfo= view.findViewById<TextView>(R.id.info_price)
        val image = view.findViewById<ImageView>(R.id.image_show_drop)

        fun bind(showDrop:SnowDrop){
            nameInfo.text = showDrop.name
            nameFlowerInfo.text = showDrop.flowerName
            quantityInfo.text = showDrop.quantity
            checkBoxPackagingInfo.text = showDrop.packaging
            priceInfo.text = "${showDrop.price}$"

            Picasso.get()
                .load(showDrop.img)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout_hw4,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var showDrop = listArrayR.get(position)
        holder.bind(showDrop)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
}