package id.shaderboi.instagramui.ui.main.home.components.story_preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.UserStory

@Composable
fun StoryPreview(
    userStory: UserStory,
    onClick: (userStory: UserStory) -> Unit,
    showAddButton: Boolean = false
) {
    var storyModifier: Modifier = Modifier
    if (!userStory.seen) {
        storyModifier = storyModifier.border(
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
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(82.dp)
    ) {
        Box {
            Box(
                modifier = storyModifier
                    .padding(4.dp)
            ) {
                AsyncImage(
                    model = userStory.userBriefInfo.imageUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(64.dp)
                        .background(MaterialTheme.colors.background)
                        .clickable {
                            onClick(userStory)
                        },
                    contentScale = ContentScale.FillBounds
                )
            }
            if (showAddButton) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(all = 6.dp)
                        .border(2.dp, MaterialTheme.colors.background, CircleShape)
                ) {
                    Image(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .background(Color(0.0F, 0.584F, 0.965F)),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }
        Text(
            text = userStory.userBriefInfo.username,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
internal fun PreviewStory() {
    val story = DummyData.userStories.first()
    StoryPreview(story, {})
}

@Preview
@Composable
internal fun PreviewAddStory() {
    val story = DummyData.userStories.first()
    StoryPreview(story, {}, true)
}
