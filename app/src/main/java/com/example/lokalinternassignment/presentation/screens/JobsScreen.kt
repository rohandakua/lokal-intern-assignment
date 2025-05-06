package com.example.lokalinternassignment.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.navigation.BottomNavItem
import com.example.lokalinternassignment.presentation.composable.BottomNavigation
import com.example.lokalinternassignment.presentation.composable.EachCardTile
import com.example.lokalinternassignment.presentation.ui.theme.mainBackgroundColor



@Composable
fun JobsScreen(
    navController: NavHostController,
    jobList: List<EachJob>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBackgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(jobList) { index ->
                EachCardTile(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp) ,
                    job = index
                )
            }
        }

        BottomNavigation(
            selectedItemInput = BottomNavItem.Jobs,
            onItemSelected = {  },
            navController = navController
        )
    }
}
