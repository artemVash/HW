package by.vashkevich.lesson1hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDz1 = findViewById<Button>(R.id.dz1)
        val btnDz2 = findViewById<Button>(R.id.dz2)
        val btnDz3 = findViewById<Button>(R.id.dz3)

        btnDz1.setOnClickListener{
            val intent = Intent(this,HomeWork1Activity::class.java)
            startActivity(intent)
        }

    }
}