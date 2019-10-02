package com.lambdaschool.androidtestdrivendesigncalculator

// Build a Calculator class with a constructor injected parameter of type Math (which is another class)
class Calculator(private val math: Math) {

    // The first function should be named factorial that accepts one parameter that calls the corresponding function in the Math class.
    fun factorial(num1: Long, num2: Long): Long {
        return math.squaresSum(num1, num2)
    }

    // The second function should be named difference that accepts two parameters that calls the corresponding function in the Math class.
    fun difference(num1: Long, num2: Long): Long {
        return math.absoluteDifference(num1, num2)
    }
}