package com.example.artificialintelligenceforlegalassistance.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.R
import com.example.artificialintelligenceforlegalassistance.components.AilaBottomAppBar
import com.example.artificialintelligenceforlegalassistance.components.CardComp
import com.example.artificialintelligenceforlegalassistance.components.CircleButtons
import com.example.artificialintelligenceforlegalassistance.components.LawChatWithAI
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens

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
            Text(text = "DashBoard", color = Color.Black, fontSize = 22.sp)
            Spacer(modifier = Modifier.size(10.dp))
            LawChatWithAI()
            Spacer(modifier = Modifier.height(10.dp))
            MostUsedCategories(navController)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            AilaBottomAppBar(navController)
        }
        FloatingActionButton(
            onClick = { navController.navigate(AilaScreens.WhatsNew.name) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 20.dp)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add"
            )
        }

    }
}

@Composable
fun MostUsedCategories(navController: NavController) {
    LazyColumn() {
        item {
            Text(text ="Most Used Categories", color = Color.Black, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(10.dp))
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
                        ) {
                            navController.navigate(AilaScreens.FamilySubcategoriesScreen.name)
                        }
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
                        ) {
                            navController.navigate(AilaScreens.RealEstateSubcategoriesScreen.name)
                        }
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
                            text = "Labour Law/Discrimin..."
                        ) {
                            navController.navigate(AilaScreens.LabourSubcategoriesScreen.name)
                        }
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
                        ) {
                            navController.navigate(AilaScreens.ConsumerSubcategoriesScreen.name)
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.width(300.dp),
                ) {
                    CircleButtons(image = R.drawable.img2, text = "Family Law") {
                        navController.navigate(AilaScreens.FamilySubcategoriesScreen.name)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    CircleButtons(image = R.drawable.img1, text = "Real Estate") {
                        navController.navigate(AilaScreens.RealEstateSubcategoriesScreen.name)
                    }
                }
                Row(
                    modifier = Modifier
                        .width(300.dp)
                        .padding(top = 10.dp)
                ) {
                    CircleButtons(image = R.drawable.labour, text = "Labour Law") {
                        navController.navigate(AilaScreens.LabourSubcategoriesScreen.name)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    CircleButtons(image = R.drawable.consumer, text = "Consumer Law") {
                        navController.navigate(AilaScreens.ConsumerSubcategoriesScreen.name)
                    }

                }
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}
