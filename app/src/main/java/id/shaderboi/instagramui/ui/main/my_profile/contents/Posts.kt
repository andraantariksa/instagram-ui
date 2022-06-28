package id.shaderboi.instagramui.ui.main.my_profile.contents

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.Post

@Composable
fun Posts(posts: List<Post>) {
    val chunkSize = 3
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        posts.chunked(chunkSize).forEach { postsRow ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                postsRow.forEach { post ->
                    PostPreview(
                        post = post,
                        modifier = Modifier.weight(1F)
                    )
                }
                if (postsRow.size != 3) {
                    Spacer(modifier = Modifier.weight((chunkSize - postsRow.size).toFloat()))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPosts() {
    val userPosts = DummyData.users[DummyData.myUsername]!!.posts
    Posts(posts = userPosts)
}