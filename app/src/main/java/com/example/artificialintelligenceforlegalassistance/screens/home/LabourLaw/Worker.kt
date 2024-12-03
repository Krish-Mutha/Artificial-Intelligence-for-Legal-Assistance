package com.example.artificialintelligenceforlegalassistance.screens.home.LabourLaw

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
fun Worker(navController: NavController, paddingValues: PaddingValues) {
    val chatViewModel: ChatViewModel = viewModel()
    val chatState by chatViewModel.chatState.collectAsState()

    LaunchedEffect(Unit) {
        chatViewModel.onEvent(ChatUiEvent.SendPrompt("provide  5 summarized case documents from supreme court of India regarding \"Worker Rights in labour law\" with year and atleast 250 words each give case title, judge names, case description"))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AilaAppBar(
            title = "Worker rights",
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
                    ModelChatItem2(response = chat.prompt)
                }
            }
        }

        // AilaBottomAppBar(navController = navController)
    }
}

//@Composable
//fun ModelChatItem2(response: String) {
//    Column(
//        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
//    ) {
//        Text(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            text = response,
//            fontSize = 17.sp
//        )
//    }
//}