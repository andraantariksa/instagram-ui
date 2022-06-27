package id.shaderboi.instagramui.ui.main.profile.my

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MyProfileTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Row() {
            Text("uesaka_sumire", fontSize = 20.sp)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
        }
        Row() {
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.List, contentDescription = "")
            }
        }
    }
    Contents()
}