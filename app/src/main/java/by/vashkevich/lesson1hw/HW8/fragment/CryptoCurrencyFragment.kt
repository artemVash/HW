package by.vashkevich.lesson1hw.HW8.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.vashkevich.lesson1hw.HW8.CryptoCurrencyRatesAdapter
import by.vashkevich.lesson1hw.HW8.ViewModelHW8
import by.vashkevich.lesson1hw.R

class CryptoCurrencyFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(ViewModelHW8::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crypto_currency,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val containRec = view.findViewById<RecyclerView>(R.id.rec_crypto_currency)

        viewModel.loadCryptoRate("e4bb1c6a-b481-4f85-8e3d-fdd679d45296")


        viewModel.cryptoRate.observe(requireActivity()){
            val adapter = CryptoCurrencyRatesAdapter(it,view.context,viewModel,colors())
            containRec.adapter = adapter
        }

    }

    private fun colors():ArrayList<Int>{
        val array = ArrayList<Int>()
        array.add(R.drawable.image_crypto)
        array.add(R.drawable.image_crypto_2)
        array.add(R.drawable.image_crypto_3)
        array.add(R.drawable.image_crypto_4)
        array.add(R.drawable.image_crypto_5)
        array.add(R.drawable.image_crypto_6)
        array.add(R.drawable.image_crypto_7)
        array.add(R.drawable.image_crypto_8)
        return array
    }
}