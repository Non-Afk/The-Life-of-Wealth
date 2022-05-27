package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*

class infoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val gender = gender.text
        val height = height.text
        val weight = weight.text
        val age = age.text
        val investment = investmentNumber.text
        val goal = goalNumber.text

        week_button.setOnClickListener {
            weeklyFunction(investment.toString(),goal.toString(),gender.toString(),height.toString(),weight.toString(),age.toString())
        }

        month_button.setOnClickListener {
            monthlyFunction(investment.toString(),goal.toString(),gender.toString(),height.toString(),weight.toString(),age.toString())
        }

        year_button.setOnClickListener {
            yearlyFunction(investment.toString(),goal.toString(),gender.toString(),height.toString(),weight.toString(),age.toString())
        }
    }

    fun weeklyFunction(investmentNumber: String, goalNumber: String,gender: String, height: String, weight: String, age: String){
        val weekly_intent = Intent(this,weeklyActivity::class.java)
        weekly_intent.putExtra("a", gender)
        weekly_intent.putExtra("b", height)
        weekly_intent.putExtra("c", weight)
        weekly_intent.putExtra("d",age)
        weekly_intent.putExtra("e", investmentNumber)
        weekly_intent.putExtra("f",goalNumber)
        startActivity(weekly_intent)
    }

    fun monthlyFunction(investmentNumber: String, goalNumber: String,gender:String, height: String, weight: String, age: String){

        var Capacity = investmentNumber
        var a=Capacity.toDouble()
        if (a > 1200 && a< 14400) {
            val month_intent = Intent(this,monthlyActivity::class.java)
            month_intent.putExtra("a", gender)
            month_intent.putExtra("b", height)
            month_intent.putExtra("c", weight)
            month_intent.putExtra("d",age)
            month_intent.putExtra("e", investmentNumber)
            month_intent.putExtra("f",goalNumber)
            startActivity(month_intent)
        }
        else{
            Toast.makeText(this, "You must have $1200 for your investment.", Toast.LENGTH_LONG).show()
        }
    }

    fun yearlyFunction(investmentNumber:String , goalNumber: String,gender:String, height: String, weight: String, age: String){

        var Capacity =investmentNumber
        var a=Capacity.toDouble()
        if (a > 14400) {
            val year_intent = Intent(this,yearlyActivity::class.java)
            year_intent.putExtra("a", gender)
            year_intent.putExtra("b", height)
            year_intent.putExtra("c", weight)
            year_intent.putExtra("d",age)
            year_intent.putExtra("e", investmentNumber)
            year_intent.putExtra("f",goalNumber)
            startActivity(year_intent)
        }
        else{
            Toast.makeText(this, "You must have $14400 for your investment.", Toast.LENGTH_LONG).show()
        }
    }

}
