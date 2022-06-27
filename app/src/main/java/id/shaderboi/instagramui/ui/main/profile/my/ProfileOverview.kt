package id.shaderboi.instagramui.ui.main.profile.my

import android.icu.text.CompactDecimalFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.User
import java.util.*

@Composable
fun ProfileOverview(user: User, modifier: Modifier = Modifier) {
    val numberFormatter = remember {
        CompactDecimalFormat.getInstance(
            Locale.getDefault(),
            CompactDecimalFormat.CompactStyle.SHORT
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = user.briefInfo.imageUrl,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(108.dp)
                .clip(CircleShape)
                .fillMaxWidth(0.5F)
        )
        Spacer(modifier = Modifier.defaultMinSize(minWidth = 32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(1F),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    numberFormatter.format(user.additionalInfo.postCount),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Posts")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    numberFormatter.format(user.additionalInfo.followers),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Followers")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    numberFormatter.format(user.additionalInfo.following),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Following")
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileOverview() {
    ProfileOverview(DummyData.users[DummyData.myUsername]!!)
}