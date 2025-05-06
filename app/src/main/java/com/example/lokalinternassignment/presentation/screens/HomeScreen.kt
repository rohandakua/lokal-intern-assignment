package com.example.lokalinternassignment.presentation.screens

import androidx.compose.runtime.Composable
import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.presentation.composable.BottomNavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lokalinternassignment.navigation.BottomNavItem
import com.example.lokalinternassignment.presentation.screens.BookmarkScreen
import com.example.lokalinternassignment.presentation.screens.JobsScreen

@Composable
fun HomeScreen(

) {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Jobs) }
    val jobList by remember { mutableStateOf(listOf<EachJob>()) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                selectedItemInput = selectedItem,
                onItemSelected = { selected ->
                    selectedItem = selected
                    navController.navigate(selected.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                navController = navController
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {

            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Jobs.route
            ) {
                composable(BottomNavItem.Jobs.route) {
                    JobsScreen(navController, jobList)
                }
                composable(BottomNavItem.Bookmarks.route) {
                    BookmarkScreen(navController , listOf())
                }
            }
        }
    }
}

