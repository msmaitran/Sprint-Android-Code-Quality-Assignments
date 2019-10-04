package com.lambdaschool.androidtestdrivendesigncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.androidtestdrivendesigncalculator.util.Validator.inputValid
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val calc = Calculator(Math())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_squares_sum.setOnClickListener {
            val num1 = et_num1.text.toString()
            val num2 = et_num2.text.toString()
            if (inputValid(num1) && inputValid(num2)) {
                tv_results.text = calc.sumSquares(num1.toInt(), num2.toInt()).toString()
            }
            onClick()
        }

        btn_absolute_difference.setOnClickListener {
            val num1 = et_num1.text.toString()
            val num2 = et_num2.text.toString()
            if (inputValid(num1) && inputValid(num2)) {
                tv_results.text = calc.absoluteDifference(num1.toInt(), num2.toInt()).toString()
            }
            onClick()
        }

        btn_factorial.setOnClickListener {
            val num1 = et_num1.text.toString()
            if (inputValid(num1)) {
                tv_results.text = calc.factorial(num1.toInt()).toString()
            }
            onClick()
        }
    }

    private fun onClick() {
        et_num1.getText().clear()
        et_num2.getText().clear()
    }
}
