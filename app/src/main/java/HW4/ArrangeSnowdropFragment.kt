package HW4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.vashkevich.lesson1hw.R

class ArrangeSnowdropFragment : Fragment() {

    lateinit var viewModel: HomeWork4ViewModel

    private val showDrop = listOf<String>(
        "Galanthus nivalis",
        "Galanthus elwesii",
        "Galanthus plicatus",
        "Galanthus woronowii"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_snowdrop_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(requireActivity()).get(HomeWork4ViewModel::class.java)

        val list = ArrayList<SnowDrop>()

        val plantSpecies = view.findViewById<AutoCompleteTextView>(R.id.plant_species)
        val buyerName = view.findViewById<EditText>(R.id.buyer_name)
        val inputQuantity = view.findViewById<EditText>(R.id.input_quantity)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBox)

        val btnOrder = view.findViewById<Button>(R.id.btn_order)

        val imageDown = view.findViewById<ImageView>(R.id.down_arrow)

        val adapter = context?.let {
            ArrayAdapter<String>(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                showDrop
            )
        }

        plantSpecies.setAdapter(adapter)


        imageDown.setOnClickListener {
            plantSpecies.showDropDown()
        }

        fun flowerImage(flower: String): String {
            return when (flower) {
                 "Galanthus nivalis" -> {
                     return "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-nivalis.jpg"
                 }
                 "Galanthus elwesii" -> {
                     return "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-elwesii-giant.jpg"
                 }
                 "Galanthus plicatus" -> {
                     return "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-plicatus-crimean.jpg"
                 }
                 "Galanthus woronowii" -> {
                     return "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-woronowii-green.jpg"
                 }

                else -> "пусто"
            }
        }

            btnOrder.setOnClickListener {

                if (buyerName.text.isNullOrEmpty() ||
                    plantSpecies.text.isNullOrEmpty() ||
                    inputQuantity.text.isNullOrEmpty()
                ) {
                    Toast.makeText(context, "Заполните все поля", Toast.LENGTH_LONG).show()
                } else {
                    viewModel.restart()

                    val checked: String = if (checkBox.isChecked) "Упаковывать"
                    else "Нe упаковывать"

                    list.add(
                        SnowDrop(
                            buyerName.text.toString(),
                            plantSpecies.text.toString(),
                            inputQuantity.text.toString(),
                            checked,
                            inputQuantity.text.toString().toDouble().times(1.25).toString(),
                            flowerImage(plantSpecies.text.toString())
                        )
                    )
                    viewModel.addList(list)
                    Toast.makeText(context, "Заказ принят", Toast.LENGTH_LONG).show()
                }
            }

        }
    }