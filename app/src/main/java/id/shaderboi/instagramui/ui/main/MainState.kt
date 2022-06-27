package id.shaderboi.instagramui.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class MainState(
    val navHostController: NavHostController
)

@Composable
fun rememberMainState(navHostController: NavHostController = rememberNavController()) = remember(navHostController) {
    MainState(
        navHostController = navHostController
    )
}