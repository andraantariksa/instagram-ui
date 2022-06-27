package id.shaderboi.instagramui.ui.main.profile.my

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.ui.common.components.Button

@Composable
fun MyProfileScreen() {
    val myUser = DummyData.users[DummyData.myUsername]!!

    val paddingHorizontal = 16.dp
    Scaffold(
        topBar = {
            MyProfileTopBar(modifier = Modifier.padding(horizontal = paddingHorizontal))
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column() {
                ProfileOverview(
                    user = myUser,
                    modifier = Modifier
                        .padding(
                            horizontal = paddingHorizontal,
                            vertical = paddingHorizontal
                        )
                )
                Descriptions(
                    userAdditionalInfo = myUser.additionalInfo,
                    modifier = Modifier
                        .padding(horizontal = paddingHorizontal)
                )
                Row(
                    modifier = Modifier
                        .padding(paddingHorizontal)
                ) {
                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .fillMaxWidth(1.0F)
                    ) {
                        Text("Edit profile")
                    }
                    Button(
                        onClick = {
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyProfileScreen() {
    MyProfileScreen()
}