package com.example.lokalinternassignment.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lokalinternassignment.presentation.ui.theme.LexendDeca
import com.example.lokalinternassignment.presentation.ui.theme.mainTextColor

@Composable
fun NormalText(
    text: String,
    modifier: Modifier = Modifier,
    textSize : Int = 48
) {

    Text(
        text = text,
        style = TextStyle(
            fontSize = textSize.sp,
            fontFamily = LexendDeca,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier,
        color = mainTextColor//Color.White
    )
}