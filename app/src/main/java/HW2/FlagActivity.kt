package HW2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.vashkevich.lesson1hw.HomeWork2Activity
import by.vashkevich.lesson1hw.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FlagActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)

        val btnBack = findViewById<FloatingActionButton>(R.id.fab_back)

        btnBack.setOnClickListener {
            val intent = Intent(this,HomeWork2Activity::class.java)
            startActivity(intent)
        }
    }
}