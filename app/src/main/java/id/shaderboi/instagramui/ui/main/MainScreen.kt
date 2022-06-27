package id.shaderboi.instagramui.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.shaderboi.instagramui.ui.main.components.InstagramBottomAppBar
import id.shaderboi.instagramui.ui.main.home.HomeScreen
import id.shaderboi.instagramui.ui.main.profile.my.MyProfileScreen

@Composable
fun MainScreen() {
    val mainState = rememberMainState()

    Scaffold(
        bottomBar = {
            InstagramBottomAppBar(mainState = mainState)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = mainState.navHostController, startDestination = "home") {
                composable(MainNavigationGraph.Home.route) {
                    HomeScreen()
                }
                composable(MainNavigationGraph.Search.route) {
//                            SearchScreen()
                }
                composable(MainNavigationGraph.Reels.route) {
//                            ReelsScreen()
                }
                composable(MainNavigationGraph.Market.route) {
//                            MarketScreen()
                }
                composable(MainNavigationGraph.MyProfile.route) {
                    MyProfileScreen()
                }
            }
        }
    }
}