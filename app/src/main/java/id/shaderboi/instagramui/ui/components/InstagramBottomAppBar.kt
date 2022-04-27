package id.shaderboi.instagramui.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun InstagramBottomAppBar() {
    BottomAppBar() {
        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Reels")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Market")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {

            },
            icon = {
                AsyncImage(
                    model = "https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fandraantariksa%2F9760691.png?alt=media&token=df8b7fea-3199-4905-a9fc-76d3edac2fe0",
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp)
                )
            }
        )
    }
}