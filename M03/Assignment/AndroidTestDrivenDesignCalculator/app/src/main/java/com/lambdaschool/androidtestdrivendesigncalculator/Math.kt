package com.lambdaschool.androidtestdrivendesigncalculator

import kotlin.math.absoluteValue

class Math {

    // Calculate the sum of squares of two numbers.
    fun squaresSum(num1: Long, num2: Long): Long {
        return num1 * num1 + num2 * num2
    }

    // Calculate the difference between the absolute values of two numbers.
    fun absoluteDifference(num1: Long, num2: Long): Long {
        val difference = num1 - num2
        return difference.absoluteValue
    }
}