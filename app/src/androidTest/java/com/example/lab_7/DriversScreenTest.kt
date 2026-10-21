package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun testDriversScreen(){

        //1. Verify navigation from the HomeScreen to the DriversScreen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()
        composeTestRule
            .onNodeWithText("FormulaZero Drivers").assertExists()

        //2. Verify  add at least one driver, and if that driver is properly displayed
        composeTestRule
            .onNodeWithTag("driverInput").performTextInput("Hamilton")
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()
        composeTestRule
            .onNodeWithText("Hamilton").assertExists()

        //3. Verify that you can properly clear the driver(s) from the list
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()
        composeTestRule
            .onNodeWithText("Hamilton").assertDoesNotExist()

        //4.Verify that the back button takes you back to the HomeScreen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()
        composeTestRule
            .onNodeWithText("FormulaZero Home").assertExists()




    }


}