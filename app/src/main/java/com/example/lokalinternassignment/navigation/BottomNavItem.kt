package com.example.lokalinternassignment.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lokalinternassignment.R

sealed class BottomNavItem (
    val route:String, val label:String,val icon: Int
){
    object Jobs : BottomNavItem ("jobs" , "Jobs" , R.drawable.work_24px)
    object Bookmarks : BottomNavItem ("bookmarks" , "Bookmarks" , R.drawable.bookmark_24px)

}