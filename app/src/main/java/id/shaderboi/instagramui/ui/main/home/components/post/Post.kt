package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.UserPost

internal val postIconSize = 28.dp

internal val postIconModifier = Modifier
    .size(postIconSize)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Post(userPost: UserPost) {
    val pagerState = rememberPagerState()
    var isLiked by remember { mutableStateOf(false) }

    val post = userPost.post
    val userBrief = userPost.userBrief

    Column {
        PostTopMenu(userBrief = userBrief)

        if (post.contents.size == 1) {
            PostContent(
                content = post.contents.first(),
                onDoubleTap = {
                    isLiked = !isLiked
                }
            )
        } else {
            HorizontalPager(
                count = post.contents.size,
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
