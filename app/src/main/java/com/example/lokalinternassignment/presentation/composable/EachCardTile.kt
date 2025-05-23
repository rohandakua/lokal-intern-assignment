package com.example.lokalinternassignment.presentation.composable

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.lokalinternassignment.R
import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.presentation.ui.theme.mainBackgroundColor
import com.example.lokalinternassignment.presentation.ui.theme.mainCardBackground

//@Composable
//@Preview(showBackground = true)
//fun EachTitleCardList() {
//    val scrollState = rememberScrollState()
//    Column(modifier = Modifier.verticalScroll(scrollState)) {
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//        EachCardTile()
//    }
//}


@Composable
fun EachCardTile(
    modifier: Modifier = Modifier
        .width(500.dp)
        .height(200.dp) ,
    job: EachJob

) {
    val title by remember { mutableStateOf("Title") }
    val location by remember { mutableStateOf("location") }
    val salary by remember { mutableStateOf("1903932043") }
    val phoneNo by remember { mutableStateOf("98989898989") }
    var isBookmarked by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            //.fillMaxSize()  // change this
            .background(color = mainBackgroundColor)  // Color(0xFF10110f)
        //.safeDrawingPadding()
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
                    .fillMaxHeight(.94f)
                    .padding(horizontal = 10.dp, vertical = 3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    // title
                    NormalText(
                        text = title,
                        textSize = 24,
                        modifier = Modifier.padding(top = 20.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth(.5f)
                                .fillMaxHeight()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // location
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_location_pin_24),
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
                                NormalText(text = location, textSize = 18)
                            }

                            // salary
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.payments_24px),
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
                                NormalText(text = salary, textSize = 18)
                            }

                            // phone no.
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_phone_24),
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
                                NormalText(text = phoneNo, textSize = 18)
                            }

                        }
                        Box(modifier  = Modifier.fillMaxSize()){
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                //button
                                Icon(
                                    painter = painterResource(id = if(isBookmarked) R.drawable.bookmark_remove_24px else R.drawable.bookmark_24px ),
                                    contentDescription = "check",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .drawBehind {
                                            drawCircle(
                                                brush = gradientBrush, alpha = 1f , radius = (size.minDimension+15)/2.0f
                                            )
                                        }
                                        .size(40.dp)
                                        .clickable {
                                            // chnge from the viewmodel
                                            isBookmarked = !isBookmarked
                                        }

                                )
                                Spacer(modifier = Modifier.width(14.dp))
                                NormalText(text =  if(isBookmarked) "Remove" else "Bookmark", textSize = 18)



                            }

                        }



                    }
                }
            }
        }
    }
}