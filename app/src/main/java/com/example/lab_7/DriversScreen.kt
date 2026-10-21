package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController){

    var driver by remember {
        mutableStateOf("")
    }
    val drivers = remember {
        mutableStateListOf<String>()
    }

    Column(modifier= Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text("FormulaZero Drivers")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("driversBackButton") // for testing
        ) {
            Text("Home Screen")

        }

        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = driver,
            onValueChange ={driver = it},
            label = {Text("Driver's name")},
            modifier = Modifier.testTag("driverInput") // for testing
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if(driver.isNotBlank()){
                    drivers.add(driver)
                    driver = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton") // for testing

        ) {
           Text("Add Driver")

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
        }
        LazyColumn{
            items(drivers){
                driverName->Text(text = driverName)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
            drivers.clear()
            },
            modifier = Modifier.testTag("clearDriversButton") // for testing
        ) {
            Text("Clear all drivers")
        }
    }



}