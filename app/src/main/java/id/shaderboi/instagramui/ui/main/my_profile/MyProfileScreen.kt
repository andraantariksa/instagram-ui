package id.shaderboi.instagramui.ui.main.my_profile

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData

val profilePaddingHorizontal = 16.dp

@Composable
fun MyProfileScreen() {
    val myUser = DummyData.users[DummyData.myUsername]!!

    Scaffold(
        topBar = {
            MyProfileTopBar(modifier = Modifier.padding(horizontal = profilePaddingHorizontal))
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
        ) {
            item {
                Profile(user = myUser)
            }
            item {
                Contents(user = myUser)
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyProfileScreen() {
    MyProfileScreen()
}