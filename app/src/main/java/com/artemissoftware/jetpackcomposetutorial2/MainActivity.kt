package com.artemissoftware.jetpackcomposetutorial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(Modifier.fillMaxSize()){


                val color = remember {
                    mutableStateOf(Color.Yellow)
                }

                ColorBox(Modifier.weight(1f).fillMaxSize()) {
                    color.value = it
                }

                Box(Modifier.background(color.value).weight(1f).fillMaxSize())
            }
        }

    }


    fun styleText(){

        val fontFamily = FontFamily(
            Font(R.font.kleeone_regular, FontWeight.Normal),
            Font(R.font.kleeone_semibold, FontWeight.SemiBold)
        )

        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))){

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ){
                            append("A")
                        }
                        append("rtemis is the ")

                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ){
                            append("H")
                        }

                        append("unter")

                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }


        }

    }



    fun imageCard(){
        setContent {

            val painter = painterResource(id = R.drawable.artemis_1)
            val description = "Artemis hunts at night"
            val title = "The hunter goddess"

            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)) {

                ImageCard(painter = painter, contentDescription = description, title = title)
            }

        }

    }

    fun modifiers(){
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .border(5.dp, Color.Magenta)
                    .padding(top = 50.dp)
                    .border(15.dp, Color.Cyan)
                    .padding(top = 50.dp)
                    .border(25.dp, Color.White)
                    .padding(top = 50.dp)

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

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
){

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ){


        
        Box(modifier = Modifier.height(200.dp)){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ),
                            startY = 300f
                        )
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }

    }
}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateState: (Color) -> Unit
){

    Box(modifier = modifier
        .background(Color.Red)
        .clickable {

            updateState(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )

        })

}