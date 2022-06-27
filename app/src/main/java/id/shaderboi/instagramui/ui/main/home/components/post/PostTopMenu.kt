package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.CheckCircle
import compose.icons.fontawesomeicons.solid.CheckCircle
import id.shaderboi.instagramui.domain.model.UserBriefInfo
import id.shaderboi.instagramui.ui.theme.Verified

@Composable
fun PostTopMenu(userBrief: UserBriefInfo) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = userBrief.imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Text(
                text = userBrief.username,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 12.dp, end = 4.dp)
            )
            if (userBrief.isOfficial) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.CheckCircle,
                    contentDescription = "",
                    modifier = Modifier
                        .size(16.dp),
                    tint = Verified,
                )
            }
        }

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "",
            modifier = postIconModifier
        )
    }
}