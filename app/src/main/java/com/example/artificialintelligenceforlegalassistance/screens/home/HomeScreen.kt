package com.example.artificialintelligenceforlegalassistance.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.R
import com.example.artificialintelligenceforlegalassistance.components.AilaBottomAppBar
import com.example.artificialintelligenceforlegalassistance.components.CardComp
import com.example.artificialintelligenceforlegalassistance.components.CircleButtons
import com.example.artificialintelligenceforlegalassistance.components.LawChatWithAI
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens


//@Preview
@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "DashBoard", color = Color.Black, fontSize = 30.sp)
            Spacer(modifier = Modifier.size(20.dp))
            LawChatWithAI()
            Spacer(modifier = Modifier.height(20.dp))
            MostUsedCategories()

            //AilaBottomAppBar(navController)
            }
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom) {

            AilaBottomAppBar(navController)
        }
        }
    }


@Composable
fun MostUsedCategories() {
    LazyColumn {
        item {
            Text(text ="Most Used Categories",color = Color.Black, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                item {
                    Column {
                        CardComp(
                            image = R.drawable.img2,
                            modifier = Modifier.width(100.dp),
                            text = "Family/Divorce"
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.width(16.dp))
                }
                item {
                    Column {
                        CardComp(
                            image = R.drawable.img1,
                            modifier = Modifier.width(100.dp),
                            text = "Real Estate/Tenant Rig.."
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.width(16.dp))
                }
                item {
                    Column {
                        CardComp(
                            image = R.drawable.labour,
                            modifier = Modifier.width(100.dp),
                            text = "Labour Law/" +
                                    "Discrimin..."
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.width(16.dp))
                }
                item {
                    Column {
                        CardComp(
                            image = R.drawable.consumer,
                            modifier = Modifier.width(100.dp),
                            text = "Consumer Law/ Fraud"
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Create Chat", color = Color.Black, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(1.dp))
                Row(
                    modifier = Modifier.width(300.dp),
                ) {
                    CircleButtons(image = R.drawable.img2, text = "Family Law")
                    Spacer(modifier = Modifier.weight(1f))
                    CircleButtons(image = R.drawable.img1, text = "Real Estate")
                }
                Row(
                    modifier = Modifier
                        .width(300.dp)
                        .padding(top = 10.dp)
                ) {
                    CircleButtons(image = R.drawable.labour, text = "Labour Law")
                    Spacer(modifier = Modifier.weight(1f))
                    CircleButtons(image = R.drawable.consumer, text = "Consumer Law")
                }
            }
        }
    }
}