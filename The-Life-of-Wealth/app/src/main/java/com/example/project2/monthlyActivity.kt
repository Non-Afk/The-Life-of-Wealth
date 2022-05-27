package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_monthly.*
import kotlinx.android.synthetic.main.activity_weekly.*
import kotlinx.android.synthetic.main.activity_weekly.calories_consume
import kotlinx.android.synthetic.main.activity_weekly.meal_consume
import kotlinx.android.synthetic.main.activity_weekly.money_left_number


class monthlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly)
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
        if (gender == "male") {
            val BMR = 66 + 6.3 * 2.20462 * weight + 12.9 * 0.393701 * height - 6.8 * age
            val calorie = BMR * 1.375 * 30
            calories_consume.text="The calories you consume for one month is: $calorie"
            val money_left = capacity - goal
            if (money_left <= 532) {
                if (calorie/30 <= 1500) {
                    val string2 = "The money for meals is about: 409$ for one month"
                    meal_consume.text="The money for meals is about: 412$ for one month"
                    val rest_money = capacity - 412
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-412)*0.25
                    utilize.text="You got $utilize1$ for utilize"
                    val extra1=(capacity-goal-412-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
                if (calorie/30 > 1500) {
                    meal_consume.text="The money for meals is about: 532$ for one month"
                    val rest_money = capacity - 532
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-532)*0.2
                    utilize.text="You got $utilize1$ for utilize"
                    val extra1=(capacity-goal-532-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
            }
            if (money_left > 532) {
                if (calorie <= 1000 / 30) {
                    meal_consume.text="The money for meals is about: 532$ for one month"
                    val rest_money = capacity - 532
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-532)*0.2
                    utilize.text="You got $utilize1$ for utilize"
                    val extra1=(capacity-goal-532-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
                if (calorie > 1000 / 30) {
                    meal_consume.text="The money for meals is about: 613$ for one month"
                    val rest_money = capacity - 613
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-613)*0.2
                    utilize.text="You got $utilize1$ for utilize"
                    val extra1=(capacity-goal-613-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
            }
        }else if (Gender == "female") {
            val BMR = 655 + 4.3 * 2.20462 * weight + 4.7 * 0.393701 * height - 4.7 * age
            val calorie = BMR * 1.375 * 30
            calories_consume.text="Calories you need for a month are:  $calorie"
            val money_left = capacity - goal
            if (money_left < 532) {
                if (calorie/30 <= 1200 ) {
                    meal_consume.text="The money for meals is about: $409 for one week"
                    val rest_money = capacity - 409
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-409)*0.2
                    utilize.text="$utilize1"
                    val extra1=(capacity-goal-409-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
                if (calorie/30 > 1200 ) {
                    meal_consume.text="The money for meals is about: $532 for one week"
                    val rest_money = capacity - 532
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-532)*0.2
                    utilize.text="$utilize1"
                    val extra1=(capacity-goal-532-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
            }
            if (money_left > 532) {
                if (calorie/30 <= 1200) {
                    meal_consume.text="The money for meals is about: $532 for one week"
                    val rest_money = capacity - 532
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-532)*0.2
                    utilize.text="$utilize1"
                    val extra1=(capacity-goal-532-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
                if (calorie/30 > 1200) {
                    meal_consume.text= "The money for meals is about: $603 for one week"
                    val rest_money = capacity - 603
                    money_left_number.text="$rest_money"
                    val utilize1=(capacity-goal-603)*0.2
                    utilize.text="$utilize1"
                    val extra1=(capacity-goal-603-utilize1)*0.15
                    extra.text="You got $extra1$ for extra, have a good meal during weekend"
                }
            }
        } else {
            Toast.makeText(this, "please input valid data", Toast.LENGTH_LONG).show()
        }
    }
}
