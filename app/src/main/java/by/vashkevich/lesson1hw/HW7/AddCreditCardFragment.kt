package by.vashkevich.lesson1hw.HW7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard
import by.vashkevich.lesson1hw.R

class AddCreditCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_credit_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(ViewModelHW7::class.java)

        val inputCardNum1 = view.findViewById<EditText>(R.id.input_card_num_1)
        val inputCardNum2 = view.findViewById<EditText>(R.id.input_card_num_2)
        val inputCardNum3 = view.findViewById<EditText>(R.id.input_card_num_3)
        val inputCardNum4 = view.findViewById<EditText>(R.id.input_card_num_4)

        val inputValidMonth = view.findViewById<EditText>(R.id.input_valid_month)
        val inputValidYear = view.findViewById<EditText>(R.id.input_valid_year)

        val inputCardHolder = view.findViewById<EditText>(R.id.input_cardholder_name)

        val inputCvv = view.findViewById<EditText>(R.id.input_cvv_cvc)

        val btnSave = view.findViewById<Button>(R.id.btn_save)

        val test = view.findViewById<Button>(R.id.fragment_sec)

        viewModel.getAll()

        btnSave.setOnClickListener {

            if (inputCardNum1.text.isNullOrEmpty() || inputCardNum1.text.length < 4  &&
                inputCardNum2.text.isNullOrEmpty() || inputCardNum2.text.length < 4 &&
                inputCardNum3.text.isNullOrEmpty() || inputCardNum3.text.length < 4  &&
                inputCardNum4.text.isNullOrEmpty() || inputCardNum4.text.length < 4 &&
                inputValidMonth.text.isNullOrEmpty() || inputValidMonth.text.length < 2 &&
                inputValidYear.text.isNullOrEmpty() || inputValidYear.text.length < 2 &&
                inputCardHolder.text.isNullOrEmpty()  &&
                inputCvv.text.isNullOrEmpty() || inputCvv.text.length < 3
            ) {

                Toast.makeText(context, "Fill in all the fields", Toast.LENGTH_SHORT).show()
            } else {
                if (inputValidMonth.text.toString().toInt() > 12) {
                    Toast.makeText(context, "not filled in correctly", Toast.LENGTH_SHORT).show()
                } else {
                    val allNum =
                        inputCardNum1.text.toString() + inputCardNum2.text.toString() + inputCardNum3.text.toString() + inputCardNum4.text.toString()

                    val creditCard = CreditCard(
                        allNum.toLong(),
                        inputValidMonth.text.toString().toInt(),
                        inputValidYear.text.toString().toInt(),
                        inputCardHolder.text.toString(),
                        inputCvv.text.toString().toInt(),
                        paymentSystem(allNum.first().toString()),
                        paymentSystemImage(allNum.first().toString())
                    )

                    viewModel.insert(creditCard)

                    Toast.makeText(context, "Credit card added", Toast.LENGTH_SHORT).show()
                    viewModel.getAll()
                }
            }

        }

        test.setOnClickListener {

            findNavController().navigate(R.id.showInfoCreditCardFragment)
        }
    }
    private fun paymentSystemImage(x : String) : Int{
        return when(x){
            "4" ->{
                return R.drawable.visa
            }
            "5" ->{
                return R.drawable.master_card
            }
            "6" ->{
                return R.drawable.maestro
            }
            else -> 0
        }
    }

    private fun paymentSystem(x : String) : String{
        return when(x){
            "4" ->{
                return "visa"
            }
            "5" ->{
                return "master card"
            }
            "6" ->{
                return "maestro"
            }
            else -> ""
        }
    }
}