package HW2

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import by.vashkevich.lesson1hw.HomeWork2Activity
import by.vashkevich.lesson1hw.R

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)


        val animationCat = findViewById<ImageView>(R.id.image_cat)
        val btnBack = findViewById<Button>(R.id.btn_animation_back)

        startAnimation(animationCat)

        btnBack.setOnClickListener {
            val intent = Intent(this,HomeWork2Activity::class.java)
            startActivity(intent)
        }


    }
    fun startAnimation(image:ImageView){
        val fragment1 = getDrawable(R.drawable.cat_0)
        val fragment2 = getDrawable(R.drawable.cat_1)
        val fragment3 = getDrawable(R.drawable.cat_2)
        val fragment4 = getDrawable(R.drawable.cat_3)

        val animation = AnimationDrawable()
        animation.isOneShot = false
        fragment1?.let { animation.addFrame(it,200) }
        fragment2?.let { animation.addFrame(it,200) }
        fragment3?.let { animation.addFrame(it,200) }
        fragment4?.let { animation.addFrame(it,200) }

        image.background = animation
        animation.start()
    }
}