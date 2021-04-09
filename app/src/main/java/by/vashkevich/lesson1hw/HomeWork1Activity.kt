package by.vashkevich.lesson1hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText
import com.squareup.picasso.Picasso

class HomeWork1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work1)

        val image = findViewById<ImageView>(R.id.image_view)
        val url = findViewById<TextInputEditText>(R.id.url_address)
        val btnImage = findViewById<Button>(R.id.button_image)

        btnImage.setOnClickListener{
            Picasso.get()
                    .load(url.text.toString())
                    .into(image)
        }
    }
}