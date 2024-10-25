package com.example.doctorappointment.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappointment.presentation.components.ScheduleDoctorCard
import com.example.doctorappointment.ui.theme.BluePrimary

@Composable
fun ScheduleScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Category Schedule
            
            items(3) {
                CategorySchedule()
            }
        }

        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(5) {
                ScheduleDoctorCard()
            }
        }
    }
}


@Composable
fun CategorySchedule(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .wrapContentWidth()
            .padding(top = 20.dp),
        color = Color(0xFF63B4FF).copy(alpha = 0.1f),
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            text = "Upcoming Schedule",
            fontFamily = FontFamily.SansSerif,
            color = BluePrimary,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScheduleScreenPreview(modifier: Modifier = Modifier) {
    ScheduleScreen()
}
