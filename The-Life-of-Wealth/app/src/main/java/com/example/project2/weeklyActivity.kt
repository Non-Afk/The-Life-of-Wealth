package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_weekly.*


class weeklyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly)


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
        if (gender =="male") {
            val BMR = 66 + 6.3 * 2.20462 * weight + 12.9 * 0.393701 * height - 6.8 * age
            val calorie = BMR * 1.375 * 7
            calories_consume.text = "The calories you consume for one week is: $calorie"
            val money_left = capacity - goal
            if (money_left >= 133) {
                if (calorie / 7 <= 1500) {
                    menu.text = "Menu Suggestion:\nBreakfast: Grain(Bread)\n" +
                            "Lunch: Rice, Meat(beef,duck meat and fish), Low-calorie vegetables\n" +
                            "Dinner: Rice, Fish, Fruit, Nuts"
                    //val string2 = "The money for meals is about: 100$ for one week"
                    meal_consume.text = "The money for meals is about: 100$ for one week"
                    val rest_money = capacity - 100
                    money_left_number.text = "$rest_money"
                }
                if (calorie / 7 > 1500) {
                    menu.text = "Menu Suggestion:\nBreakfast: Grain(bread), egg, milk, Ham\n" +
                            "Lunch: Rice, Meat(beef,duck meat and pork and fish), vegetables, Honey cake\n" +
                            "Dinner: Potato, Noodle, Corn,Meat"
                    meal_consume.text = "The money for meals is about: 133$ for one week"
                    val rest_money = capacity - 133
                    money_left_number.text = "$rest_money"
                }
            }
            if (money_left < 133) {
                if (calorie / 7 <= 1500) {
                    menu.text = "Menu Suggestion:\nBreakfast: Grain(Bread)\n" +
                            "Lunch: Rice, Meat(beef and fish), Low-calorie vegetables\n" +
                            "Dinner: Rice, Fish, Fruit, Nuts"
                    //val string2 = "The money for meals is about: 133$ for one week"
                    meal_consume.text = "The money for meals is about: 133$ for one week"
                    val rest_money = capacity - 133
                    money_left_number.text = "$rest_money"
                }
                if (calorie / 7 > 1500) {
                    menu.text = "Menu Suggestion:\nBreakfast: Grain(bread), Egg, Milk\n" +
                            "Lunch: Rice, Meat(beef,duck meat and pork and fish), Honey cake\n" +
                            "Dinner: Potato, Noodle, Corn"
                    //val string2 = "The money for meals is about: 168$ for one week"
                    meal_consume.text = "The money for meals is about: 168$ for one week"
                    val rest_money = capacity - 168
                    money_left_number.text = "$rest_money"
                }
            }
        }
        if (gender == "female") {
            val BMR1 = 655 + 4.3 * 2.20462 * weight + 4.7 * 0.393701 * height - 4.7 * age
            val calorie1 = BMR1 * 1.375 * 7
            val string1 = "Calories you need for a week are:  $calorie1"
            calories_consume.setText(string1)
            val money_left1 = capacity - goal
            if (money_left1 < 100) {
                if (calorie1/7 <= 1200) {
                    menu.text="Menu Suggestion:\nBreakfast: Grain(Bread)\n" +
                            "Lunch: Rice, Meat(beef,duck meat and fish), Low-calorie vegetables\n" +
                            "Dinner: Rice, Fish, Fruit, Nuts"
                    meal_consume.text="The money for meals is about: $82 for one week"
                    val rest_money = capacity - 82
                    money_left_number.text="$rest_money"
                }
                if (calorie1/7 >1200) {
                    menu.text="Menu Suggestion:\nBreakfast: Grain(bread), egg, milk, Ham\n" +
                            "Lunch: Rice, Meat(beef,duck meat and pork and fish), vegetables\n" +
                            "Dinner: Potato, Noodle, Corn"
                    meal_consume.text="The money for meals is about: $100 for one week"
                    val rest_money = capacity - 100
                    money_left_number.text="$rest_money"
                }
            }
            if (money_left1 > 100) {
                if (calorie1/7<= 1200) {
                    menu.text="Menu Suggestion:\nBreakfast: Grain(Bread)\n" +
                            "Lunch: Rice, Meat(beef,duck meat and fish), Low-calorie vegetables\n" +
                            "Dinner: Rice, Fish, Fruit, Nuts"
                    meal_consume.text="The money for meals is about: $100 for one week"
                    val rest_money = capacity - 100
                    money_left_number.text="$rest_money"
                }
                if (calorie1/7 > 1200) {
                    menu.text="Menu Suggestion:\nBreakfast: Grain(bread), egg, milk, Ham\n" +
                            "Lunch: Rice, Meat(beef,duck meat and pork and fish), vegetables, Honey cake\n" +
                            "Dinner: Potato, Noodle, Corn, Meat"
                    meal_consume. text="The money for meals is about: $132 for one week"
                    val rest_money = capacity - 132
                    money_left_number.text="$rest_money"
                }
            }
        } else {
            Toast.makeText(this, "please input valid data", Toast.LENGTH_LONG).show()
        }
    }
}

