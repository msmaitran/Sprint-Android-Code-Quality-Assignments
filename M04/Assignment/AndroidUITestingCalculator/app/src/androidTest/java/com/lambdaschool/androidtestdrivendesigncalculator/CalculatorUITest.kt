package com.lambdaschool.androidtestdrivendesigncalculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CalculatorUITest: UITestBase() {

    companion object {
        private val NUM1 = "5"
        private val NUM2 = "4"
        private val SUM_SQUARES = "41"
        private val ABSOLUTE_DIFFERENCE = "1"
        private val FACTORIAL = "120"
    }

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_calcSumOfSquares() {
        // Setup
        onView(withId(R.id.et_num1)).perform(typeText(NUM1), closeSoftKeyboard())
        onView(withId(R.id.et_num2)).perform(typeText(NUM2), closeSoftKeyboard())

        // Execute
        onView(withId(R.id.btn_squares_sum)).perform(click())

        // Check
        onView(withId(R.id.tv_results)).check(matches(withText(SUM_SQUARES)))
    }

    @Test
    fun b_calcAbsoluteDifference() {
        // Setup
        onView(withId(R.id.et_num1)).perform(typeText(NUM1), closeSoftKeyboard())
        onView(withId(R.id.et_num2)).perform(typeText(NUM2), closeSoftKeyboard())

        // Execute
        onView(withId(R.id.btn_absolute_difference)).perform(click())

        // Check
        onView(withId(R.id.tv_results)).check(matches(withText(ABSOLUTE_DIFFERENCE)))
    }

    @Test
    fun c_calcFactorial() {
        // Setup
        onView(withId(R.id.et_num1)).perform(typeText(NUM1), closeSoftKeyboard())

        // Execute
        onView(withId(R.id.btn_factorial)).perform(click())

        // Check
        onView(withId(R.id.tv_results)).check(matches(withText(FACTORIAL)))
    }
}