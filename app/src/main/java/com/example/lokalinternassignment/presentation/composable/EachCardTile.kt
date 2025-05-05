package com.example.lokalinternassignment.presentation.composable

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.lokalinternassignment.presentation.ui.theme.mainBackgroundColor
import com.example.lokalinternassignment.presentation.ui.theme.mainCardBackground
@Composable
@Preview(showBackground = true)
fun EachTitleCardList(){
    val scrollState = rememberScrollState ()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
        EachCardTile()
    }
}



@Composable
@Preview(showBackground = true)
fun EachCardTile (
    modifier: Modifier = Modifier.width(500.dp).height(300.dp)

){
    Box(
        modifier = modifier
            //.fillMaxSize()  // change this
            .background(color = mainBackgroundColor)  // Color(0xFF10110f)
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = mainCardBackground,
                    disabledContainerColor = mainBackgroundColor
                ),
                modifier = Modifier
                    .fillMaxWidth(.98f)
                    .fillMaxHeight(.98f)
                    .padding(horizontal = 10.dp, vertical = 3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {


                }
            }
        }
    }
}