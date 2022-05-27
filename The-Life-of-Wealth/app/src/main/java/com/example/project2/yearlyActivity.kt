package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_yearly.*

class yearlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yearly)
        val weeklyIntent = intent
        val Gender:String? = weeklyIntent.getStringExtra("a")
        val Height:String? = weeklyIntent.getStringExtra("b")
        val Weight:String? = weeklyIntent.getStringExtra("c")
        val Age:String? = weeklyIntent.getStringExtra("d")
        val Capacity:String? = weeklyIntent.getStringExtra("e")
        val Goal:String? = weeklyIntent.getStringExtra("f")

        val gender:String=Gender.toString()
        val height = Height.toString().toDouble()
        val weight = Weight.toString().toDouble()
        val age = Age.toString().toDouble()
        val capacity = Capacity.toString().toDouble()
        val goal = Goal.toString().toDouble()

        confirm.setOnClickListener {
            val rent = rent.text.toString().toDouble()

            val availablemoney = capacity - goal - rent * 12
            total.text = "Your money for this year is:$capacity"


            val c: Double = availablemoney * 0.07
            clothes.text = "The money for cloth is:$c"


            if (gender == "male") {
                val BMR = 66 + 6.3 * 2.20462 * weight + 12.9 * 0.393701 * height - 6.8 * age
                val calorie = BMR * 1.375 * 30
                ca.text = "You need caloris for one month is:$calorie"
            } else if (gender == "female") {
                val BMR = 655 + 4.3 * 2.20462 * weight + 4.7 * 0.393701 * height - 4.7 * age
                val calorie = BMR * 1.375 * 30
                ca.text = "You need caloris for one month is:$calorie"
            }


            val x: Double = (availablemoney - c) / 12
            monthfee.text = "The money for each month is:$x"

            val f: Double = x * 0.70
            food.text = "The money for food in one month is:$f"

            val t: Double = x * 0.1
            trans.text = "Your money for tranportation for this month is:$t"

            val h: Double = x - f - t
            holiday.text = "The money for holiday and dinne out is:$h"


            remind.text = "Your money has saved:$goal"

        }
    }
}
