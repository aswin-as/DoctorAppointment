package com.example.doctorappointment.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.doctorappointment.R
import com.example.doctorappointment.ui.theme.BluePrimary
import com.example.doctorappointment.ui.theme.PurpleGrey
import com.example.doctorappointment.ui.theme.WhiteBackground

@Composable
fun MenuHome(modifier: Modifier = Modifier, icon: Int, title : String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.size(72.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = WhiteBackground),
            onClick = { }
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = icon),
                contentDescription = "Menu Icon",
                colorFilter = ColorFilter.tint(color = BluePrimary)
            )
        }

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = PurpleGrey
        )
    }
}




@Preview(showSystemUi = false)
@Composable
fun MenuHomePreview(modifier: Modifier = Modifier) {
        MenuHome(icon = R.drawable.ic_covid, title = "covid")
}