package id.shaderboi.instagramui.ui.main.my_profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import id.shaderboi.instagramui.domain.model.UserAdditionalInfo
import id.shaderboi.instagramui.ui.theme.Link
import id.shaderboi.instagramui.ui.theme.PrimaryText
import id.shaderboi.instagramui.ui.theme.SecondaryText

@Composable
fun Descriptions(userAdditionalInfo: UserAdditionalInfo, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        userAdditionalInfo.fullName?.let {
            Text(
                it,
                color = PrimaryText,
                fontWeight = FontWeight.Bold
            )
        }
        userAdditionalInfo.userCaption?.let {
            Text(it, color = SecondaryText)
        }
        userAdditionalInfo.description?.let {
            Text(it, color = PrimaryText)
        }
        userAdditionalInfo.url?.let {
            Text(it, color = Link)
        }
    }
}