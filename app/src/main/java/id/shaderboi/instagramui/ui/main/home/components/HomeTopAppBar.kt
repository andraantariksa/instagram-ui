package id.shaderboi.instagramui.ui.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.R

@Composable
fun HomeTopAppBar() {
    val isDarkTheme = isSystemInDarkTheme()

    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.instagram_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp),
                    colorFilter = if (isDarkTheme) {
                        ColorFilter.tint(color = Color.White)
                    } else {
                        null
                    }
                )
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            }
        },
        actions = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Love",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Message",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        },
        elevation = 0.dp
    )
}

@Preview
@Composable
fun PreviewHomeTopAppBar() {
    HomeTopAppBar()
}
