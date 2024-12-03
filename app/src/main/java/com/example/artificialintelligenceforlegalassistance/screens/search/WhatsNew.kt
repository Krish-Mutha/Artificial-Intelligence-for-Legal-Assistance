package com.example.artificialintelligenceforlegalassistance.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
import com.example.artificialintelligenceforlegalassistance.components.AilaBottomAppBar
import com.example.artificialintelligenceforlegalassistance.components.AilaLogo
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens

data class LegalTopic(
    val title: String,
    val content: String
)

// Sample data (replace with your actual data)
val topics = listOf(
    LegalTopic(
        title = "Bharatiya Nyaya Sanhita",
        content = """
            Simplification and Reduction of Sections: Eliminates outdated and redundant IPC sections, focusing on clarity and ease of application.
            Enhanced Focus on Crimes Against Women and Children: Introduces stringent measures against human trafficking, sexual exploitation, and domestic violence, with severe punishments for rape and new sections addressing stalking and acid attacks.
            Introduction of New Offences: Addresses cybercrimes, financial frauds, and environmental crimes, reflecting contemporary challenges.
        """.trimIndent()
    ),
    LegalTopic(
        title = "Bharatiya Nagarik Suraksha Sanhita",
        content = """
            Digitalisation and Modernisation: Mandates the use of digital records and e-governance platforms, including e-FIR for online complaint registration, enhancing accessibility and efficiency.
            Videography in Search and Seizure Operations: Ensures transparency and accountability in law enforcement actions.
            Provisions for Speedy Trials: Introduces fast-track courts and summary trials for minor offences to expedite the judicial process.
        """.trimIndent()
    ),
    LegalTopic(
        title = "Bharatiya Sakshya Adhiniyam",
        content = """
            Expansion of the Definition of Evidence: Recognises emails, text messages, and digital documents as valid evidence, provided they meet authenticity criteria.
            Inclusion of Digital and Electronic Records: Provides detailed guidelines for handling digital evidence, ensuring reliability and integrity.
            Integration of Forensic Science: Establishes the National Forensic Science University and mandates forensic team involvement in serious crimes, improving the quality and credibility of investigations.
        """.trimIndent()
    ),
    LegalTopic(
        title = "Bharatiya Cyber Suraksha Sanhita",
        content = """
            Strengthening Cyber Security: Introduces measures to combat cyber threats and enhance digital security infrastructure.
            Regulation of Digital Transactions: Establishes guidelines for secure digital transactions and electronic payments.
            Protection Against Online Frauds: Implements safeguards to mitigate risks associated with online frauds and scams.
        """.trimIndent()
    ),
    LegalTopic(
        title = "Bharatiya Vriksha Suraksha Sanhita",
        content = """
            Conservation of Biodiversity: Introduces laws to protect and conserve the environment, focusing on biodiversity and ecosystem preservation.
            Regulation of Pollution: Sets stringent norms for controlling pollution and promoting sustainable development practices.
            Promotion of Green Technologies: Incentivises the adoption of green technologies and practices for environmental sustainability.
        """.trimIndent()
    )
)

@Composable
fun WhatsNew(navController: NavController) {
    Scaffold(topBar = {
        AilaAppBar(
            title = "      What's New?",
            icon = Icons.Default.ArrowBack,
            navController = navController,
            showProfile = false
        ) {
            navController.navigate(AilaScreens.HomeScreen.name)
        }
    }) {

    LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it )
        ) {
            items(topics.size) { index ->
                LegalTopicCard(topic = topics[index], index = index + 1)
                Spacer(modifier = Modifier.height(16.dp))
            }
            item{
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            AilaBottomAppBar(navController)
        }
    }

}

@Composable
fun LegalTopicCard(topic: LegalTopic, index: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)
    ) {
        Text(text = topic.title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = topic.content, style = MaterialTheme.typography.bodyMedium)
    }
}
