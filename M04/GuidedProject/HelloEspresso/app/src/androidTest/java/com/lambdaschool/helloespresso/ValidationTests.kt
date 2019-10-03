package com.lambdaschool.helloespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
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
class ValidationTests: UITestBase() {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun changeEditText_validEmails() {
        val invalidEmails = listOf(
            "valid@email.com",
            "test@gmail.com"
        )

        // Perform
        invalidEmails.forEach { email ->
            onView(withId(R.id.email_input)).perform(
                *commonViewAction(email)
            )
        }

        // Check
        onView(withId(R.id.check_email_box)).check(matches(isChecked()))
    }

    @Test
    fun changedEditText_validPasswords() {
        val validPasswords = listOf(
            "Adj$2k-29!",
            "029njnJhj3bj-JKJ$()"
        )

        validPasswords.forEach {
            onView(withId(R.id.password_input)).perform(
                *commonViewAction(it)
            )
        }

        onView(withId(R.id.check_password_box)).check(matches(isChecked()))
    }

}