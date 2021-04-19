package by.vashkevich.lesson1hw

import HW3.HomeWork3ViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class HomeWork3Activity : AppCompatActivity() {

    lateinit var viewModel:HomeWork3ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work3)

        viewModel = ViewModelProvider(this).get(HomeWork3ViewModel::class.java)

        //Кнопки областей
        val btnRegion1 = findViewById<LinearLayout>(R.id.region_1)
        val btnRegion2 = findViewById<LinearLayout>(R.id.region_2)
        val btnRegion3 = findViewById<LinearLayout>(R.id.region_3)
        //LinearLayout списка продуктов
        val productRegion1 = findViewById<LinearLayout>(R.id.product_region_1)
        val productRegion2 = findViewById<LinearLayout>(R.id.product_region_2)
        val productRegion3 = findViewById<LinearLayout>(R.id.product_region_3)
        //counter region 1
        val counterCornRegion1 = findViewById<TextView>(R.id.corn_counter_region_1)
        val counterPotatoRegion1 = findViewById<TextView>(R.id.potato_counter_region_1)
        val counterCabbageRegion1 = findViewById<TextView>(R.id.cabbage_counter_region_1)
        val counterBeetRegion1 = findViewById<TextView>(R.id.beet_counter_region_1)
        //counter region 2
        val counterCornRegion2 = findViewById<TextView>(R.id.corn_counter_region_2)
        val counterPotatoRegion2 = findViewById<TextView>(R.id.potato_counter_region_2)
        val counterCabbageRegion2 = findViewById<TextView>(R.id.cabbage_counter_region_2)
        val counterBeetRegion2 = findViewById<TextView>(R.id.beet_counter_region_2)
        //counter region 3
        val counterCornRegion3 = findViewById<TextView>(R.id.corn_counter_region_3)
        val counterPotatoRegion3 = findViewById<TextView>(R.id.potato_counter_region_3)
        val counterCabbageRegion3 = findViewById<TextView>(R.id.cabbage_counter_region_3 )
        val counterBeetRegion3 = findViewById<TextView>(R.id.beet_counter_region_3)
        //LinearLayout продуктов region 1
        val productCornRegion1 = findViewById<LinearLayout>(R.id.product_corn_region_1)
        val productPotatoRegion1 = findViewById<LinearLayout>(R.id.product_potato_region_1)
        val productCabbageRegion1 = findViewById<LinearLayout>(R.id.product_cabbage_region_1)
        val productBeetRegion1 = findViewById<LinearLayout>(R.id.product_beet_region_1)
        //LinearLayout продуктов region 2
        val productCornRegion2 = findViewById<LinearLayout>(R.id.product_corn_region_2)
        val productPotatoRegion2 = findViewById<LinearLayout>(R.id.product_potato_region_2)
        val productCabbageRegion2 = findViewById<LinearLayout>(R.id.product_cabbage_region_2)
        val productBeetRegion2 = findViewById<LinearLayout>(R.id.product_beet_region_2)
        //LinearLayout продуктов region 3
        val productCornRegion3 = findViewById<LinearLayout>(R.id.product_corn_region_3)
        val productPotatoRegion3 = findViewById<LinearLayout>(R.id.product_potato_region_3)
        val productCabbageRegion3 = findViewById<LinearLayout>(R.id.product_cabbage_region_3)
        val productBeetRegion3 = findViewById<LinearLayout>(R.id.product_beet_region_3)
        //Кнопка старт
        val btnStart = findViewById<TextView>(R.id.btn_start)
        //Кнопка назад
        val btnBackHW3 = findViewById<ImageView>(R.id.btn_back_hw3)

        //Контроль 1 области
        viewModel.harvestCornRegion1.observe(this) {
            countControl(it, counterCornRegion1, productCornRegion1)
        }

        viewModel.harvestPotatoRegion1.observe(this){
            countControl(it, counterPotatoRegion1, productPotatoRegion1)
        }

        viewModel.harvestCabbageRegion1.observe(this){
            countControl(it, counterCabbageRegion1, productCabbageRegion1)
        }
        viewModel.harvestBeetRegion1.observe(this){
            countControl(it, counterBeetRegion1, productBeetRegion1)
        }
        //Контроль 2 области
        viewModel.harvestCornRegion2.observe(this) {
            countControl(it, counterCornRegion2, productCornRegion2)
        }

        viewModel.harvestPotatoRegion2.observe(this){
            countControl(it, counterPotatoRegion2, productPotatoRegion2)
        }

        viewModel.harvestCabbageRegion2.observe(this){
            countControl(it, counterCabbageRegion2, productCabbageRegion2)
        }
        viewModel.harvestBeetRegion2.observe(this){
            countControl(it, counterBeetRegion2, productBeetRegion2)
        }
        //Контроль 3 области
        viewModel.harvestCornRegion3.observe(this) {
            countControl(it, counterCornRegion3, productCornRegion3)
        }

        viewModel.harvestPotatoRegion3.observe(this){
            countControl(it, counterPotatoRegion3, productPotatoRegion3)
        }

        viewModel.harvestCabbageRegion3.observe(this){
            countControl(it, counterCabbageRegion3, productCabbageRegion3)
        }
        viewModel.harvestBeetRegion3.observe(this){
            countControl(it, counterBeetRegion3, productBeetRegion3)
        }
        viewModel.regionControl.observe(this){
            regionControlWin(it,btnRegion1,btnRegion2,btnRegion3)
        }
        btnBackHW3.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btnRegion1.setOnClickListener {
            productRegion1.visibility = View.VISIBLE
            productRegion2.visibility = View.INVISIBLE
            productRegion3.visibility = View.INVISIBLE
        }

        btnRegion2.setOnClickListener {
            productRegion1.visibility = View.INVISIBLE
            productRegion2.visibility = View.VISIBLE
            productRegion3.visibility = View.INVISIBLE
        }

        btnRegion3.setOnClickListener {
            productRegion1.visibility = View.INVISIBLE
            productRegion2.visibility = View.INVISIBLE
            productRegion3.visibility = View.VISIBLE
        }

        btnStart.setOnClickListener {
            viewModel.restart()
            viewModel.harvesting()
        }

    }

    private fun countControl(it:Int, view1:TextView, view2:LinearLayout){
        if (it>1000){
            view2.setBackgroundResource(R.drawable.style_product_win)
        }else{
            view2.setBackgroundResource(R.drawable.style_button_pressed_false)
        }
        view1.text = "$it/1000 гк"
    }

    private fun regionControlWin(it:Int, btn1:LinearLayout, btn2:LinearLayout, btn3:LinearLayout){
        when (it) {
            1 -> {
                btn1.setBackgroundResource(R.drawable.btn_region_win_hw3)
            }
            2 -> {
                btn2.setBackgroundResource(R.drawable.btn_region_win_hw3)
            }
            3 -> {
                btn3.setBackgroundResource(R.drawable.btn_region_win_hw3)
            }
            else -> {
                btn1.setBackgroundResource(R.drawable.btn_region_hw3)
                btn2.setBackgroundResource(R.drawable.btn_region_hw3)
                btn3.setBackgroundResource(R.drawable.btn_region_hw3)
            }
        }
    }

}