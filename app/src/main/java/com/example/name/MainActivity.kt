package com.example.name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.name.R.*
import com.example.name.ui.theme.NameTheme
//import com.example.name.ui.theme.Poppins
import com.example.name.ui.theme.PoppinsSemi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameTheme {
               MyScreen()
            }
        }
    }
}

@Preview
@Composable
fun MyScreen() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
 Surface(
     modifier = Modifier.fillMaxSize(),
     shape = RectangleShape,
     color = Color(0xFF250055),

 ) {
      Column (
          horizontalAlignment = Alignment.CenterHorizontally
      ){
          Image(
              modifier = Modifier.padding(
                  top = 126.dp
              ),
              painter = painterResource(id = R.drawable.message),
              contentDescription = "",


              )
          Text(
              text = "Say Hi",
              fontFamily = FontFamily(listOf(Font(R.font.poppins_bold))),
              fontSize = 20.sp,
              color = Color.White
          )
          Text(
              modifier = Modifier.padding(
                  top = 61.dp
              ),
              text = "User",
              fontFamily = FontFamily(listOf(Font(R.font.poppins_bold))),
              fontSize = 16.sp,
              color = Color.White
          )
          Button(
              onClick = {   buttonClickedState.value= ! buttonClickedState.value },
              colors= ButtonDefaults.buttonColors(
                  containerColor = Color.White,
              ),
              modifier = Modifier
                  .padding(
                      top = 61.dp
                  )

          ) {
              Text(
                  text = "Enter your name",
                  fontFamily = FontFamily(listOf(Font(R.font.poppins_semi_bold))),
                  fontSize = 16.sp,
                  color = Color(0xFF250055)
                  )

          }
          if (buttonClickedState.value){
              Box(
                  contentAlignment = Alignment.TopCenter
              ) {
                  Enter()
              }

          } else{
              Box {}
          }
      }
 }
}

@Preview
@Composable
fun Enter() {
    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.size(317.dp, 209.dp),


    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 18.dp,
                    start = 26.dp,
                    end = 26.dp
                )
        ) {
            Text(
                text = "Enter your name",
                fontFamily = FontFamily(listOf(Font(R.font.poppins_semi_bold))),
                fontSize = 16.sp,
                color = Color(0xFF250055)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = "Name",
                onValueChange = {},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0xFF8B8B8B)
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
                contentAlignment = Alignment.BottomEnd

            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF94A3B8),
                                fontSize = 14.sp,
                                fontFamily = PoppinsSemi,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("Cancel")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF250055),
                                fontSize = 14.sp,
                                fontFamily = PoppinsSemi,
                                fontWeight = FontWeight.Medium
                            )
                        ) {
                            append("  ")
                            append(" Set")
                        }
                    }
                )
            }

        }

    }
}
