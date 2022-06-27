package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.placeholder.material.placeholder
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.*
import compose.icons.fontawesomeicons.solid.Heart
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.Content
import id.shaderboi.instagramui.domain.model.UserPost
import id.shaderboi.instagramui.util.ResourceState

private val iconModifier = Modifier
    .size(28.dp)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Post(userPost: UserPost) {
    val pagerState = rememberPagerState()
    var isLiked by remember { mutableStateOf(false) }

    val post = userPost.post
    val userBrief = userPost.userBrief

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
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
                    fontWeight = FontWeight.Bold
                )
                if (userBrief.isOfficial) {
                    Icon(
                        imageVector = FontAwesomeIcons.Regular.CheckCircle,
                        contentDescription = "",
                        modifier = Modifier
                            .size(16.dp)
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "",
                modifier = iconModifier
            )
        }

        if (post.contents.size == 1) {
            var state by remember { mutableStateOf(ResourceState.Loading) }
            var modifier: Modifier = Modifier
            if (state == ResourceState.Loading) {
                modifier = modifier
                    .height(50.dp)
                    .placeholder(true)
            }
            when (val image = post.contents.first()) {
                is Content.Image -> {
                    AsyncImage(
                        model = image.url,
                        contentDescription = "",
                        modifier = modifier,
                        onLoading = { painter ->
                            state = ResourceState.Loading
                        },
                        onSuccess = { painter ->
                            state = ResourceState.Loading
                        },
                        onError = { painter ->
                            state = ResourceState.Error
                        }
                    )
                }
                is Content.Video -> TODO()
            }
        } else {
            HorizontalPager(
                count = post.contents.size,
                state = pagerState
            ) { page ->
                PostContent(post.contents[page])
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .weight(1F),
            ) {
                Icon(
                    imageVector = if (isLiked) FontAwesomeIcons.Solid.Heart else FontAwesomeIcons.Regular.Heart,
                    contentDescription = "",
                    modifier = iconModifier
                        .clickable {
                            isLiked = !isLiked
                        },
                    tint = if (isLiked) Color.Red else LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Icon(
                    imageVector = FontAwesomeIcons.Regular.Comment,
                    contentDescription = "",
                    modifier = iconModifier
                )
                Icon(
                    imageVector = FontAwesomeIcons.Regular.PaperPlane,
                    contentDescription = "",
                    modifier = iconModifier
                )
            }

            if (post.contents.size > 1) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1F),
                    verticalAlignment = Alignment.Top
                ) {
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        activeColor = Color(0F, 0.584F, 0.965F),
                        inactiveColor = Color(0.659F, 0.659F, 0.659F)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .weight(1F)
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Regular.Bookmark,
                    contentDescription = "",
                    modifier = iconModifier
                )
            }
        }
    }
}

@Composable
@Preview
fun PostPreview() {
    Post(DummyData.posts.first())
}
