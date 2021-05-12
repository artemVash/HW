package by.vashkevich.lesson1hw.HW7

import HW4.HomeWork4ViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.HW7.database.entity.CreditCard
import by.vashkevich.lesson1hw.R

class InfoCreditCardFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(ViewModelHW7::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_credit_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contain = resources.getStringArray(R.array.payment)

        val recCreditCart = view.findViewById<RecyclerView>(R.id.rec_info_credit_card)
        val search = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val btnSearch = view.findViewById<ImageView>(R.id.image_search)
        val arrayAdapter =
            ArrayAdapter<String>(view.context, android.R.layout.simple_list_item_1, contain)
        search.setAdapter(arrayAdapter)
        viewModel.getAll()
        recCreditCart.hasFixedSize()

        viewModel.cardList.observe(requireActivity()) {
            val adapter = CreditCardAdapter(it, viewModel, view.context)
            recCreditCart.adapter = adapter
        }

        btnSearch.setOnClickListener {
            if (search.text.isEmpty()) {
                viewModel.cardList.observe(requireActivity()) {
                    val adapter = CreditCardAdapter(it, viewModel, view.context)
                    recCreditCart.adapter = adapter
                }
            } else {
                viewModel.getCardByPayment(search.text.toString())
                viewModel.cardPayment.observe(requireActivity()) {
                    val adapter = CreditCardAdapter(it, viewModel, view.context)
                    recCreditCart.adapter = adapter

                }
            }
        }


    }

//        recCreditCart.adapter = viewModel.cardList.value?.let { CreditCardAdapter(it) }

}

