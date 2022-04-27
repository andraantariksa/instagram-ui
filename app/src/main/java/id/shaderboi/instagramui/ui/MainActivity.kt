package id.shaderboi.instagramui.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.shaderboi.instagramui.ui.components.InstagramBottomAppBar
import id.shaderboi.instagramui.ui.components.InstagramTopAppBar
import id.shaderboi.instagramui.ui.home.HomeScreen
import id.shaderboi.instagramui.ui.theme.InstagramUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable(NavigationGraph.Home.route) {
                            HomeScreen()
                        }
                        composable(NavigationGraph.Search.route) {
//                            SearchScreen()
                        }
                        composable(NavigationGraph.Reels.route) {
//                            ReelsScreen()
                        }
                        composable(NavigationGraph.Market.route) {
//                            MarketScreen()
                        }
                        composable(NavigationGraph.Profile.route) {
//                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}
