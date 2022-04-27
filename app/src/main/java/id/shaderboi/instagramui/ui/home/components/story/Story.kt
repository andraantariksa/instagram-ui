package id.shaderboi.instagramui.ui.home.components.story

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import id.shaderboi.instagramui.data.DummyData
import id.shaderboi.instagramui.domain.model.story.UserPreview

@Composable
fun Story(userPreview: UserPreview) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(82.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    2.dp,
                    Brush.linearGradient(
                        listOf(
                            Color(0.976F, 0.616F, 0.294F),
                            Color(0.773F, 0.18F, 0.565F)
                        ),
                        Offset(0.0F, Float.POSITIVE_INFINITY),
                        Offset(Float.POSITIVE_INFINITY, 0.0F),
                    ),
                    CircleShape
                )
                .padding(4.dp)
        ) {
            AsyncImage(
                model = userPreview.imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp)
                    .background(MaterialTheme.colors.background),
                contentScale = ContentScale.FillBounds
            )
//            Image(
//                imageVector = Icons.Default.Add,
//                contentDescription = "",
//                modifier = Modifier
//                    .size(10.dp)
//                    .clip(CircleShape)
//                    .background(Color(0.0F, 0.584F, 0.965F))
//                    .absoluteOffset(x = (0.75F * 64.0F).dp)
//            )
        }
        Text(
            text = userPreview.username,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
internal fun PreviewStory() {
    Story(DummyData.userPreviews.first())
}
