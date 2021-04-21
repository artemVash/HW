package HW4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.vashkevich.lesson1hw.R
import com.squareup.picasso.Picasso

class InfoSnowdropFragment :Fragment() {

    lateinit var viewModel: HomeWork4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(HomeWork4ViewModel::class.java)
        return inflater.inflate(R.layout.fragment_snowdrop_info,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInfo = view.findViewById<TextView>(R.id.info_name)
        val nameFlowerInfo= view.findViewById<TextView>(R.id.info_show_drop)
        val quantityInfo= view.findViewById<TextView>(R.id.info_quantity)
        val checkBoxPackagingInfo= view.findViewById<TextView>(R.id.info_packaging)
        val priceInfo= view.findViewById<TextView>(R.id.info_price)
        val image = view.findViewById<ImageView>(R.id.image_show_drop)

        viewModel.listM.observe(requireActivity()){
             it.forEach{
                nameInfo.text = it.name
                nameFlowerInfo.text = it.flowerName
                quantityInfo.text = it.quantity
                checkBoxPackagingInfo.text = it.packaging
                priceInfo.text = "${it.price}$"

                Picasso.get()
                .load(it.img)
                .into(image)
            }
        }
    }
}