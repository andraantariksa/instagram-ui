package id.shaderboi.instagramui.ui.main.my_profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.UserPlus
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.User
import id.shaderboi.instagramui.ui.common.components.Button

@Composable
fun Profile(user: User, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ProfileOverview(
            user = user,
            modifier = Modifier
                .padding(
                    horizontal = profilePaddingHorizontal,
                    vertical = profilePaddingHorizontal
                )
        )
        Descriptions(
            userAdditionalInfo = user.additionalInfo,
            modifier = Modifier
                .padding(horizontal = profilePaddingHorizontal)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(profilePaddingHorizontal)
        ) {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .weight(1F)
                    .height(42.dp)
            ) {
                Text("Edit profile")
            }
            Button(
                modifier = Modifier
                    .size(42.dp),
                onClick = {
                },
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.UserPlus,
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfile() {
    val user = DummyData.users[DummyData.myUsername]!!
    Profile(
        user = user
    )
}