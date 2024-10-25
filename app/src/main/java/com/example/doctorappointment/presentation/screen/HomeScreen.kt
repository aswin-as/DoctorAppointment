package com.example.doctorappointment.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappointment.R
import com.example.doctorappointment.presentation.components.MenuHome
import com.example.doctorappointment.presentation.components.NearDoctorCard
import com.example.doctorappointment.presentation.components.ScheduleTimeContent
import com.example.doctorappointment.ui.theme.BluePrimary
import com.example.doctorappointment.ui.theme.GraySecond
import com.example.doctorappointment.ui.theme.PurpleGrey
import com.example.doctorappointment.ui.theme.WhiteBackground

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .padding(top = 42.dp, start = 16.dp, end = 16.dp)
    ) {
        Column {
            HeaderContent()
            
            Spacer(modifier = Modifier.height(32.dp))

            ScheduledContent()

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                placeholder = {
                    Text(
                        text = "Check For Doctor ",
                        fontWeight = FontWeight.Normal,
                        color = PurpleGrey
                    )
                },

                leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Icon Search")
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = WhiteBackground,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp),
                value = text ,
                onValueChange = {newText->
                    text = newText
                },
                singleLine = true
            )


            // Menu Home

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MenuHome(icon = R.drawable.ic_covid, title = "Covid")
                MenuHome(icon = R.drawable.ic_doctor, title = "Doctor")
                MenuHome(icon = R.drawable.ic_medicine, title = "Medicine")
                MenuHome(icon = R.drawable.ic_hospital, title = "Hospital")
            }

            //Near Content
            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = "Near Doctor",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            LazyColumn(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 16.dp)// it's for the bottom area just look at there you can see that
            ) {
                items(3) {
                    NearDoctorCard()
                }
            }

        }
    }
}


@Composable
fun ScheduledContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = BluePrimary,
        tonalElevation = 1.dp,
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
//                .background(Color.Red) it's tested for card
                .padding(vertical = 16.dp, horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.img_doctor_1),
                    contentDescription = "Doctor Image"
                )

                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = "Dr. Ibnu Simba",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "General Doctor",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Light,
                        color = GraySecond
                    )
                }

                Image(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Arrow Next",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(1.dp)
                    .alpha(0.6f),
                color = Color.White
            )

            //schedule time
            ScheduleTimeContent(contentColor = Color.White)

        }

    }
}


@Composable
private fun HeaderContent(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text = "Hello",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Medium,
                color = PurpleGrey
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Hi, Aswin",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
                )
        }

        Image(
            modifier = Modifier.size(56.dp),
            painter = painterResource(R.drawable.img_header_content),
            contentDescription = "Image Header Content"
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}