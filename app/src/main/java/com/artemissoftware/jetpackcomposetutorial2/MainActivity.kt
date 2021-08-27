package com.artemissoftware.jetpackcomposetutorial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .border(5.dp, Color.Magenta).padding(top = 50.dp)
                    .border(15.dp, Color.Cyan).padding(top = 50.dp)
                    .border(25.dp, Color.White).padding(top = 50.dp)

            ) {
                Text(text = "Artemis")
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "Software")
            }
        }

    }


    fun rows_columns(){

        setContent {

//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween
//
//            ) {
//                Text(text = "Artemis")
//                Text(text = "Software")
//            }


            Row(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight(0.7f)
                    .background(Color.Green),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "Artemis")
                Text(text = "Software")
                Text(text = "Github")
            }


        }

    }

}

