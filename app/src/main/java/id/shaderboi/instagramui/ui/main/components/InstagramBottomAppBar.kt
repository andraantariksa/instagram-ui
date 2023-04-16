package id.shaderboi.instagramui.ui.main.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.ui.main.MainNavigationGraph
import id.shaderboi.instagramui.ui.main.MainState

@Composable
fun InstagramBottomAppBar(mainState: MainState) {
    val navigation = mainState.navHostController
    val backStackEntry by navigation.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    BottomAppBar() {
        BottomNavigationItem(
            selected = currentRoute == MainNavigationGraph.Home.route,
            onClick = {
                navigation.navigate(MainNavigationGraph.Home.route)
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        )
        BottomNavigationItem(
            selected = currentRoute == MainNavigationGraph.Search.route,
            onClick = {
                navigation.navigate(MainNavigationGraph.Search.route)
            },
            icon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
        )
        BottomNavigationItem(
            selected = currentRoute == MainNavigationGraph.Reels.route,
            onClick = {
                navigation.navigate(MainNavigationGraph.Reels.route)
            },
            icon = {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Reels")
            }
        )
        BottomNavigationItem(
            selected = currentRoute == MainNavigationGraph.MyProfile.route,
            onClick = {
                navigation.navigate(MainNavigationGraph.MyProfile.route)
            },
            icon = {
                AsyncImage(
                    model = DummyData.users["uesaka_sumire"]!!.briefInfo.imageUrl,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp)
                )
            }
        )
    }
}