package com.example.doctorappointment.presentation.components

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappointment.R

@Composable
fun ScheduleTimeContent(
    modifier: Modifier = Modifier,
    contentColor: androidx.compose.ui.graphics.Color
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Content(
            icon = R.drawable.ic_date,
            title = "Sunday",
            contentColor = contentColor
        )

        Content(
            icon = R.drawable.ic_clock,
            title = "11.00AM - 12.00PM",
            contentColor = contentColor
        )
    }
}


@Composable
fun Content(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    contentColor: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Blue
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = icon),
            colorFilter = ColorFilter.tint(color = contentColor),
            contentDescription ="Icon Date",
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = title,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = contentColor
        )
    }
}



@Preview()
@Composable
fun ScheduleTimeContentPreview(modifier: Modifier = Modifier) {
    ScheduleTimeContent(contentColor = androidx.compose.ui.graphics.Color.White)
}