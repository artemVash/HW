package by.vashkevich.lesson1hw

import HW4.ArrangeSnowdropFragment
import HW4.InfoSnowdropFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeWork4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work4)

        val fragmentArrange = ArrangeSnowdropFragment()
        val fragmentInfo = InfoSnowdropFragment()

        val btnArrange = findViewById<Button>(R.id.button_arrange)
        val btnInfo = findViewById<Button>(R.id.button_info)

        btnArrange.setOnClickListener {
           supportFragmentManager.beginTransaction().replace(R.id.container,fragmentArrange).commit()
        }

        btnInfo.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container,fragmentInfo).commit()
        }

    }
}