package com.example.artificialintelligenceforlegalassistance.navigation

enum class AilaScreens {
    PreSplashScreen,
    SplashScreen,
    SplashScreen2,
    SplashScreen3,
    LoginScreen,
    CreateAccountScreen,
    HomeScreen,
    SearchScreen,
    SettingsScreen,
    StatsScreen,
    ChatScreen,
    RightDetailsScreen,
    FamilySubcategoriesScreen,
    RealEstateSubcategoriesScreen,
    LabourSubcategoriesScreen,
    ConsumerSubcategoriesScreen,
    familyLaws,
    ChildCustody,
    Alimony,
    property_div,
    Products,
    ProductsW,
    Fraud,
    ConsumerRights,
    ContractsTerms,
    Termination,
    Worker,
    Workplace,
    Neighbour,
    RealEstate,
    Tenant,
    WhatsNew;
    companion object {
        fun fromRoute(route: String?): AilaScreens
        =when(route?.substringBefore("/")){
            PreSplashScreen.name -> PreSplashScreen
            SplashScreen.name -> SplashScreen
            SplashScreen2.name -> SplashScreen2
            SplashScreen3.name -> SplashScreen3
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            HomeScreen.name -> HomeScreen
            SearchScreen.name -> SearchScreen
            SettingsScreen.name -> SettingsScreen
            StatsScreen.name -> StatsScreen
            ChatScreen.name -> ChatScreen
            RightDetailsScreen.name->RightDetailsScreen
            FamilySubcategoriesScreen.name->FamilySubcategoriesScreen
            RealEstateSubcategoriesScreen.name->RealEstateSubcategoriesScreen
            LabourSubcategoriesScreen.name->LabourSubcategoriesScreen
            ConsumerSubcategoriesScreen.name->ConsumerSubcategoriesScreen
            familyLaws.name->familyLaws
            ChildCustody.name->ChildCustody
            Alimony.name->Alimony
            property_div.name->property_div
            Products.name->Products
            ProductsW.name->ProductsW
            Fraud.name->Fraud
            ContractsTerms.name->ContractsTerms
            Termination.name->Termination
            Worker.name->Worker
            Workplace.name->Workplace
            Neighbour.name->Neighbour
            RealEstate.name->RealEstate
            Tenant.name->Tenant
            WhatsNew.name->WhatsNew
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}