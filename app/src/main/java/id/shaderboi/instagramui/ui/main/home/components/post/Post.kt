package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.UserPost

internal val postIconSize = 28.dp

internal val postIconModifier = Modifier
    .size(postIconSize)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Post(userPost: UserPost) {
    val pagerState = rememberPagerState()
    var isLiked by remember { mutableStateOf(false) }

    val post = userPost.post
    val userBrief = userPost.userBrief

    Column {
        if (post.contents.size == 1) {
            Box {
                PostContent(
                    content = post.contents.first(),
                    onDoubleTap = {
                        isLiked = !isLiked
                    }
                )
                PostTopMenu(userBrief = userBrief)
            }
        } else {
            PostTopMenu(userBrief = userBrief)
            HorizontalPager(
                pageCount = post.contents.size,
                state = pagerState
            ) { page ->
                PostContent(
                    post.contents[page],
                    onDoubleTap = {
                        isLiked = !isLiked
                    }
                )
            }
        }

        PostBottomMenu(
            isMultipleContent = post.contents.size > 1,
            pagerState = pagerState,
            isLiked = isLiked,
            onPressLike = {
                isLiked = !isLiked
            }
        )
    }
}

@Composable
@Preview
fun PostPreview() {
    Post(DummyData.posts.first())
}
