package com.lambdaschool.helloespresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TitleUITest: UITestBase() {

    companion object {
        private val TITLE_TEXT = "This Is My Title"
    }

    @Rule // junit test rule
    @JvmField // allows for compatibility with Kotlin
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_changeTitle_sameActivity() {
        // Setup
        Espresso.onView(ViewMatchers.withId(R.id.title_input))
            .perform(ViewActions.typeText(TITLE_TEXT), ViewActions.closeSoftKeyboard())

        // Execute
        Espresso.onView(ViewMatchers.withId(R.id.change_title_button)).perform(ViewActions.click())

        // Check
        Espresso.onView(ViewMatchers.withId(R.id.title_view))
            .check(ViewAssertions.matches(ViewMatchers.withText(TITLE_TEXT)))
    }

    @Test
    fun b_changeTitle_sameActivity() {
        // Setup
        Espresso.onView(ViewMatchers.withId(R.id.title_input))
            .perform(ViewActions.typeText(TITLE_TEXT), ViewActions.closeSoftKeyboard())

        // Execute
        Espresso.onView(ViewMatchers.withId(R.id.pass_title_button)).perform(ViewActions.click())

        // Check
        Espresso.onView(ViewMatchers.withId(R.id.show_title_view))
            .check(ViewAssertions.matches(ViewMatchers.withText(TITLE_TEXT)))
        viewPressBack()
//        onView(withId(R.id.title_view)).check(matches(withText(TITLE_TEXT)))
    }

    @Ignore("Skip this test for now")
    @Test
    fun anotherTest() {
        Espresso.onView(ViewMatchers.withId(R.id.title_input))
            .perform(ViewActions.clearText(), ViewActions.typeText(TITLE_TEXT))
    }
}