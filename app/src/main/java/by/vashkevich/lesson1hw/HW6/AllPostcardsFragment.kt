package by.vashkevich.lesson1hw.HW6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import by.vashkevich.lesson1hw.R

class AllPostcardsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_postcards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tankPostcard = view.findViewById<LinearLayout>(R.id.tank_layout)
        val starPostcard = view.findViewById<LinearLayout>(R.id.star_layout)

        val imageFirstFragment = view.findViewById<ImageView>(R.id.may_9)

        val imageStar = view.findViewById<ImageView>(R.id.star)
        val imageVictory = view.findViewById<ImageView>(R.id.victory)

        val extraFirstFragment = FragmentNavigatorExtras(
            Pair(imageFirstFragment,"may")
        )

        val extraSecondFragment = FragmentNavigatorExtras(
            Pair(imageStar,"star_tr"),
            Pair(imageVictory,"victory_tr")
        )


        tankPostcard.setOnClickListener {
            findNavController().navigate(R.id.showFirstPostcardFragment,null,null,extraFirstFragment)
        }

        starPostcard.setOnClickListener {
            findNavController().navigate(R.id.showSecondPostcardFragment,null,null,extraSecondFragment)
        }
    }

}