package com.example.doctorappointment.presentation.screen

import android.graphics.BlurMaskFilter.Blur
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doctorappointment.navigation.screen.BottomNavItemScreen
import com.example.doctorappointment.ui.theme.BluePrimary
import com.example.doctorappointment.ui.theme.PurpleGrey

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }

    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavItemScreen.Home,
        BottomNavItemScreen.Schedule,
        BottomNavItemScreen.Chat,
        BottomNavItemScreen.Profile
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                contentColor = Color.White,
                tonalElevation = 8.dp
            ) {
                bottomNavigationItems.forEachIndexed { index, bottomNavItemScreen ->
                 NavigationBarItem(
                     colors = NavigationBarItemDefaults.colors(
                         selectedTextColor = BluePrimary,
                         selectedIconColor = BluePrimary,
                         unselectedTextColor = PurpleGrey,
                         unselectedIconColor = PurpleGrey
                     ),
                     selected = index == navigationSelectedItem,
                     icon = { 
                         Icon(
                             painter = painterResource(id = bottomNavItemScreen.icon),
                             contentDescription = "Icon Bottom Nav")
                     },
                     label = {
                         Text(
                             text = bottomNavItemScreen.title,
                             fontFamily = FontFamily.Serif,
                             fontWeight = FontWeight.Medium,
                             color = Color(0xFF63B4FF)
                         )
                     },
                     alwaysShowLabel = index == navigationSelectedItem,
                     onClick = {
                         navigationSelectedItem = index
                         navController.navigate(bottomNavItemScreen.route) {
                             popUpTo(navController.graph.findStartDestination().id) {
                                 saveState = true
                             }
                             launchSingleTop = true
                             restoreState = true
                         }
                     }
                 )
                }
            }
        }
    ) { paddingValues ->
            NavHost(
                modifier = Modifier.padding(paddingValues = paddingValues),
                navController = navController,
                startDestination = BottomNavItemScreen.Home.route
            ) {
                composable(route = BottomNavItemScreen.Home.route) {
                    HomeScreen()
                }

                composable(route = BottomNavItemScreen.Schedule.route) {
                    ScheduleScreen()
                }

                composable(route = BottomNavItemScreen.Chat.route) {

                }

                composable(route = BottomNavItemScreen.Profile.route) {

                }
            }
    }
}



@Preview
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    MainScreen()
}