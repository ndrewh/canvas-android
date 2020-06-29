package com.instructure.student.ui.uiautomator

import android.os.SystemClock.sleep
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiaTest {

    @Test
    fun test1() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Press home button
        device.pressHome()

        // Show apps
        //val allAppsButton = device.findObject(UiSelector().description("Apps list"))
        val allAppsButton = device.findObject(UiSelector().descriptionContains("Apps"))
        allAppsButton.clickAndWaitForNewWindow()

        // Open teacher app
        val studentApp = device.findObject(UiSelector().description("Canvas Teacher"))
        studentApp.clickAndWaitForNewWindow();

        // Go to "Living in Seattle" course
        val lisCourse = device.findObject(UiSelector().text("Living in Seattle"))
        lisCourse.clickAndWaitForNewWindow()

        // Launch student view
        val scrollable = UiScrollable(UiSelector().className("androidx.recyclerview.widget.RecyclerView"))
        scrollable.setAsVerticalList()
        scrollable.scrollToEnd(10)
        scrollable.flingToEnd(10)
        //scrollable.scrollTextIntoView("Student View")
        val studentViewButton = scrollable.getChildByText(UiSelector().className("android.widget.TextView"), "Student View")
        studentViewButton.clickAndWaitForNewWindow()

        // Mix in some Espresso to open the "Living in Seattle" course
        //onView(withText("Living in Seattle")).perform(click())
        //onView(withText("Student View")).check(matches(isDisplayed()))

        sleep(3000)
    }
}