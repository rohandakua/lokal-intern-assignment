package com.example.lokalinternassignment.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lokalinternassignment.R
import com.example.lokalinternassignment.navigation.BottomNavItem
import com.example.lokalinternassignment.navigation.BottomNavItem.Bookmarks
import com.example.lokalinternassignment.presentation.ui.theme.mainBackgroundColor
import com.example.lokalinternassignment.presentation.ui.theme.mainCardBackground

@Composable
fun BottomNavItemView(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val tintColor = if (isSelected) Color.Blue else Color.Gray

    androidx.compose.material3.IconButton(onClick = onClick, modifier = Modifier.fillMaxWidth()) {

    }
}

@Composable
fun BottomNavigation(
    selectedItemInput: BottomNavItem = BottomNavItem.Jobs,
    onItemSelected: (BottomNavItem) -> Unit = {},
    navController: NavHostController
) {
    val items = listOf(BottomNavItem.Jobs, Bookmarks)
    var selectedItem:BottomNavItem = selectedItemInput

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = mainCardBackground,
            disabledContainerColor = mainBackgroundColor
        ),
        modifier = Modifier
            .fillMaxWidth(.98f)
            .padding(horizontal = 10.dp, vertical = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(.5f)
                    .clickable { selectedItem = Bookmarks
                                // navigate to bookmark screen
                        navController.navigate(selectedItem.route){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                        }
                               }
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = items.get(0).icon),
                    contentDescription = "check",
                    tint = Color.Black,
                    modifier = Modifier
                        .drawBehind {
                            drawCircle(
                                brush = gradientBrush, alpha = 1f
                            )
                        }
                        .size(25.dp))
                Spacer(modifier = Modifier.width(10.dp))
                if (selectedItem == items.get(0))
                    GradientText(text = items.get(0).label, textSize = 18)
                else
                    NormalText(text = items.get(0).label, textSize = 18)

            }
            Column(
                modifier = Modifier.clickable {
                    selectedItem = BottomNavItem.Jobs
                    // navigate to Job screen
                    navController.navigate(selectedItem.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                    }
                }.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = items.get(1).icon),
                    contentDescription = "check",
                    tint = Color.Black,
                    modifier = Modifier
                        .drawBehind {
                            drawCircle(
                                brush = gradientBrush, alpha = 1f
                            )
                        }
                        .size(25.dp))
                Spacer(modifier = Modifier.width(10.dp))
                if (selectedItem == items.get(1))
                    GradientText(text = items.get(1).label, textSize = 18)
                else
                    NormalText(text = items.get(1).label, textSize = 18)
            }
        }


    }

}