package id.shaderboi.instagramui.ui.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.R

@Composable
fun HomeTopAppBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.instagram_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp)
//                        .background(Color.Red)
                )
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            }
        },
        actions = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Post")
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Love")
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Message")
            }
        },
        elevation = 0.dp
    )
}