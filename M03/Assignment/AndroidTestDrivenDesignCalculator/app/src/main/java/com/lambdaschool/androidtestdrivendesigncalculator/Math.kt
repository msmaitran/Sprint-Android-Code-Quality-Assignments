package com.lambdaschool.androidtestdrivendesigncalculator

import kotlin.math.absoluteValue

class Math {

    // Calculate the sum of squares of two numbers.
    fun squaresSum(num1: Int, num2: Int): Int {
        return (num1 * num1) + (num2 * num2)
    }

    // Calculate the difference between the absolute values of two numbers.
    fun absoluteDifference(num1: Int, num2: Int): Int {
        return (num1.absoluteValue - num2.absoluteValue)
    }
}