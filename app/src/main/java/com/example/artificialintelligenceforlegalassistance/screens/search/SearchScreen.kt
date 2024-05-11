package com.example.artificialintelligenceforlegalassistance.screens.search

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
import com.example.artificialintelligenceforlegalassistance.components.InputField
import com.example.artificialintelligenceforlegalassistance.model.MRight
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    Scaffold(topBar = {
        AilaAppBar(title = "Search Your Right", icon = Icons.Default.ArrowBack, navController = navController, showProfile = false){
            navController.navigate(AilaScreens.HomeScreen.name)
        }
    }) { it ->
        Surface(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
            ) {
            Column {
                SearchForm(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Log.d("Search", "Searched item: $it")
                }
                Spacer(modifier = Modifier.height(13.dp))
                Text(text = "Most Frequent Searches...",Modifier.padding(start = 16.dp), style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(13.dp))
                RightList(navController)

            }
        }
    }

}


@Composable
fun RightList(navController: NavHostController) {

    val listOfRights = listOf(
        MRight(
            article = 0,
            title = "The Preamble",
            description = "\"WE, THE PEOPLE OF INDIA, having solemnly resolved to constitute India into a SOVEREIGN SOCIALIST SECULAR DEMOCRATIC REPUBLIC and to secure to all its citizens: JUSTICE, social, economic and political; LIBERTY of thought, expression, belief, faith and worship;\\nEQUALITY of status and of opportunity; and to promote among them all FRATERNITY assuring the dignity of the individual and the unity and integrity of the Nation; IN OUR CONSTITUENT ASSEMBLY this twenty-sixth day of November, 1949, do HEREBY ADOPT, ENACT AND GIVE TO OURSELVES THIS CONSTITUTION\"\n"
        ),
        MRight(
            article = 1,
            title = "Name and territory of the Union",
            description = "(1) India, that is Bharat, shall be a Union of States.\n\n \n\n(2) The States and the territories thereof shall be as specified in the First Schedule.\n\n \n\n(3) The territory of India shall comprise —\n\n(a) the territories of the States;\n\n(b) the Union territories specified in the First Schedule; and\n\n(c) such other territories as may be acquired."
        ),
        MRight(
            article = 37,
            title = "Application of the principles contained in this Part",
            description = "The provisions contained in this Part shall not be enforceable by any court, but the principles therein laid down are nevertheless fundamental in the governance of the country and it shall be the duty of the State to apply these principles in making laws."
        ),
        MRight(
            article = 3,
            title = "Protection and improvement of environment and safeguarding of forests and wild life",
            description = "The State shall endeavour to protect and improve the environment and to safeguard the forests and wild life of the country."
        )
    )

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items = listOfRights) { right ->
            RightCard(right = right, navController = navController)
        }
    }
}



@Composable
fun SearchForm(modifier: Modifier = Modifier,
               loading:Boolean = false,
               hint: String = "Search",
               onSearch:(String) -> Unit = {}) {
    Column {
        val searchQueryState = rememberSaveable {
            mutableStateOf("")
        }
        val keyboardController = LocalSoftwareKeyboardController.current
        val valid = remember(searchQueryState.value) {
            searchQueryState.value.trim().isNotEmpty()
        }

        InputField(
            valueState = searchQueryState,
            labelId = "Search",
            enabled = true,
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyboardController?.hide()
            }
        )

    }
}


@Composable
fun RightCard(right: MRight, navController: NavHostController) {
    Card(modifier = Modifier
        .clickable { navController.navigate(AilaScreens.SettingsScreen.name) }
        .fillMaxWidth()
        .height(100.dp)
        .padding(5.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
        Row (Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically){
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Text(text = right.title, overflow = TextOverflow.Ellipsis,maxLines = 1,
                style = MaterialTheme.typography.titleMedium)
        }
        Row (Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically){
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Text(text = right.description, overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall)

        }
    }
}
