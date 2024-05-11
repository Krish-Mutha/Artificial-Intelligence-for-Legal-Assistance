package com.example.artificialintelligenceforlegalassistance.navigation



import PreSplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.artificialintelligenceforlegalassistance.screens.chat.ChatsScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.HomeScreen
import com.example.artificialintelligenceforlegalassistance.screens.login.LoginScreen
import com.example.artificialintelligenceforlegalassistance.screens.search.SearchScreen
import com.example.artificialintelligenceforlegalassistance.screens.settings.SettingsScreen
import com.example.artificialintelligenceforlegalassistance.screens.splash.SplashScreen
import com.example.artificialintelligenceforlegalassistance.screens.splash.SplashScreen2
import com.example.artificialintelligenceforlegalassistance.screens.splash.SplashScreen3
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AilaNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty())
            AilaScreens.SplashScreen.name
        else
            AilaScreens.PreSplashScreen.name){
        composable(AilaScreens.PreSplashScreen.name){
            PreSplashScreen(navController)
        }
        composable(AilaScreens.SplashScreen.name){
            SplashScreen(navController)
        }
        composable(AilaScreens.SplashScreen2.name){
            SplashScreen2(navController)
        }
        composable(AilaScreens.SplashScreen3.name){
            SplashScreen3(navController)
        }
        composable(AilaScreens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(AilaScreens.LoginScreen.name){
            LoginScreen(navController)
        }
        composable(AilaScreens.ChatScreen.name){
            ChatsScreen(navController)
        }
        composable(AilaScreens.SettingsScreen.name){
            SettingsScreen(navController)
        }
        composable(AilaScreens.SearchScreen.name){
            SearchScreen(navController)
        }

    }
}