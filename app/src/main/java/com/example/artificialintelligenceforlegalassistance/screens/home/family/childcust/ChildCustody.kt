package com.example.artificialintelligenceforlegalassistance.screens.home.family.childcust
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.Card
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.artificialintelligenceforlegalassistance.R
//import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
//import com.example.artificialintelligenceforlegalassistance.components.CardComp
//import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ChildCustody(navController: NavController){
//    Scaffold(topBar = {
//        AilaAppBar(
//            title = "Top 5 Relevant Cases",
//            icon = Icons.Default.ArrowBack,
//            navController = navController,
//            showProfile = false
//        ) {
//            navController.navigate(AilaScreens.HomeScreen.name)
//        }
//    }) { paddingValues ->
//        Surface(
//            modifier = Modifier
//                .padding(paddingValues)
//                .fillMaxSize()
//        ) {
//            LazyRow(
//                Modifier
//                    .fillMaxWidth()
//                    .padding(5.dp) ){
//
//                item {
//                    LazyColumn(
//                        Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp),
//                        verticalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        item {
//                            Column {
//                                Card(
//                                    modifier = Modifier.width(360.dp).clickable { navController.navigate(AilaScreens.c1.name)}
//                                ) {
//                                    Text(text = "T.S. Ramesh v. V. Krithika (2021)\n", fontWeight = FontWeight.Bold, fontSize = 16.sp)
//                                    Text(text = "The court acknowledged the strained relationship between the parents and their impact on the child. The judgment emphasized the child's welfare, considering the child's education and psychologica....")
//                                }
//                            }
//                        }
//                        item {
//                            Spacer(modifier = Modifier.height(16.dp))
//                        }
//                        item {
//                            Column {
//                                Card(
//                                    modifier = Modifier.width(360.dp).clickable { navController.navigate(AilaScreens.c2.name)}
//
//                                ) {
//                                    Text(text = "Kritika T R v. Nadeem Khan\n", fontWeight = FontWeight.Bold, fontSize = 16.sp)
//                                    Text(text = "This case analyzed the broader legal principles governing child custody and guardianship under the Hindu Minority and Guardianship Act and the Guardians and Wards Act. It dealt with the welfare of a minor named Thalbir. The Supreme Court reiterated that the welfare...")
//                                }
//                            }
//                        }
//                        item {
//                            Spacer(modifier = Modifier.height(16.dp).clickable { navController.navigate(AilaScreens.c3.name)})
//                        }
//                        item {
//                            Column {
//                                Card(
//                                    modifier = Modifier.width(360.dp).clickable { navController.navigate(AilaScreens.c4.name)}
//
//                                ) {
//                                    Text(text = "Smriti Madan Kansagra v. Perry Kansagra (2020)\n", fontWeight = FontWeight.Bold, fontSize = 16.sp)
//                                    Text(text = "Smriti Madan Kansagra and Perry Kansagra were engaged in a custody dispute over their son. The father had been granted visitation rights by the High Court, but the mother sought sole custody, alleging the father's non-cooperation. The Supreme Court granted custody to the mother....")
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//    }
//}

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
import com.example.artificialintelligenceforlegalassistance.screens.chat.ChatUiEvent
import com.example.artificialintelligenceforlegalassistance.screens.chat.ChatViewModel

@Composable
fun ChildCustody(navController: NavController, paddingValues: PaddingValues) {
    val chatViewModel: ChatViewModel = viewModel()
    val chatState by chatViewModel.chatState.collectAsState()

    // Launch effect to send initial prompt
    LaunchedEffect(Unit) {
        chatViewModel.onEvent(ChatUiEvent.SendPrompt("provide  5 summarized case documents from supreme court of India regarding \"Child Custody\" with year and atleast 250 words each give case title, judge names, case description"))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AilaAppBar(
            title = "Child Custody",
            showProfile = false,
            icon = Icons.Default.ArrowBack,
            navController = navController
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(8.dp)
                .border(width = 1.dp, color = Color.Gray, shape = MaterialTheme.shapes.medium),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(chatState.chatList) { index, chat ->
                if (!chat.isFromUser) {
                    ModelChatItem(response = chat.prompt)
                }
            }
        }

        // AilaBottomAppBar(navController = navController)
    }
}

@Composable
fun ModelChatItem(response: String) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = response,
            fontSize = 17.sp
        )
    }
}

