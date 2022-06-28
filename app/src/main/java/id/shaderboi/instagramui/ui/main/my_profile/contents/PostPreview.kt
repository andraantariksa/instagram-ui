package id.shaderboi.instagramui.ui.main.my_profile.contents

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.Content
import id.shaderboi.instagramui.domain.model.Post

@Composable
fun PostPreview(post: Post, modifier: Modifier = Modifier) {
    val url = when (val firstContent = post.contents.first()) {
        is Content.Image -> firstContent.url
        is Content.Video -> firstContent.url
    }
    AsyncImage(
        model = url,
        contentDescription = "",
        modifier = modifier.aspectRatio(1F),
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
fun PreviewPostPreview() {
    val userPosts = DummyData.users["uesaka_sumire"]!!.posts
    PostPreview(userPosts.first())
}