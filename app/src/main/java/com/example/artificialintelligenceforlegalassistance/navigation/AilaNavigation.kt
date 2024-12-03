package com.example.artificialintelligenceforlegalassistance.navigation



import PreSplashScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.artificialintelligenceforlegalassistance.screens.chat.ChatsScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.Consumer.ConsumerRights
import com.example.artificialintelligenceforlegalassistance.screens.home.Consumer.ConsumerSubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.Consumer.Fraud
import com.example.artificialintelligenceforlegalassistance.screens.home.Consumer.ProductW
import com.example.artificialintelligenceforlegalassistance.screens.home.Consumer.Products
import com.example.artificialintelligenceforlegalassistance.screens.home.HomeScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.LabourLaw.ContractsTerms
import com.example.artificialintelligenceforlegalassistance.screens.home.LabourLaw.LabourSubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.LabourLaw.Termination
import com.example.artificialintelligenceforlegalassistance.screens.home.LabourLaw.Worker
import com.example.artificialintelligenceforlegalassistance.screens.home.LabourLaw.Workplace
import com.example.artificialintelligenceforlegalassistance.screens.home.RealEstate.Neighbour
import com.example.artificialintelligenceforlegalassistance.screens.home.RealEstate.RealEstate
import com.example.artificialintelligenceforlegalassistance.screens.home.RealEstate.RealEstateSubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.RealEstate.Tenant
import com.example.artificialintelligenceforlegalassistance.screens.home.family.FamilySubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.family.alimony.Alimony
import com.example.artificialintelligenceforlegalassistance.screens.home.family.childcust.ChildCustody
import com.example.artificialintelligenceforlegalassistance.screens.home.family.divorce.familyLaws
import com.example.artificialintelligenceforlegalassistance.screens.home.family.prop_div.property_div
import com.example.artificialintelligenceforlegalassistance.screens.login.LoginScreen
import com.example.artificialintelligenceforlegalassistance.screens.search.SearchScreen
import com.example.artificialintelligenceforlegalassistance.screens.search.WhatsNew
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
            ChatsScreen(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.SettingsScreen.name){
            SettingsScreen(navController)
        }
        composable(AilaScreens.SearchScreen.name){
            SearchScreen(navController)
        }

        composable(AilaScreens.FamilySubcategoriesScreen.name){
            FamilySubcategoriesScreen(navController)
        }
        composable(AilaScreens.RealEstateSubcategoriesScreen.name){
            RealEstateSubcategoriesScreen(navController)
        }
        composable(AilaScreens.LabourSubcategoriesScreen.name){
            LabourSubcategoriesScreen(navController)
        }
        composable(AilaScreens.ConsumerSubcategoriesScreen.name){
            ConsumerSubcategoriesScreen(navController)
        }
        composable(AilaScreens.familyLaws.name){
            familyLaws(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.ChildCustody.name){
            ChildCustody(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Alimony.name){
            Alimony(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.property_div.name){
            property_div(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.ConsumerRights.name){
            ConsumerRights(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Fraud.name){
            Fraud(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Products.name){
            Products(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.ProductsW.name){
            ProductW(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.ContractsTerms.name){
            ContractsTerms(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Termination.name){
            Termination(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Worker.name){
            Worker(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Workplace.name){
            Workplace(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Neighbour.name){
            Neighbour(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.RealEstate.name){
            RealEstate(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.Tenant.name){
            Tenant(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.WhatsNew.name){
            WhatsNew(navController)
        }



    }
}




