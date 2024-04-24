package com.example.artificialintelligenceforlegalassistance.navigation

enum class AilaScreens {
    SplashScreen,
    SplashScreen2,
    SplashScreen3,
    LoginScreen,
    CreateAccountScreen,
    HomeScreen,
    SearchScreen,
    RightsScreen,
    UpdateScreen,
    StatsScreen;
    companion object {
        fun fromRoute(route: String?): AilaScreens
        =when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            SplashScreen2.name -> SplashScreen2
            SplashScreen3.name -> SplashScreen3
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            HomeScreen.name -> HomeScreen
            SearchScreen.name -> SearchScreen
            RightsScreen.name -> RightsScreen
            UpdateScreen.name -> UpdateScreen
            StatsScreen.name -> StatsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}