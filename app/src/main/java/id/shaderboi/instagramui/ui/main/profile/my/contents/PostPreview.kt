package id.shaderboi.instagramui.ui.main.profile.my.contents

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.Post
import id.shaderboi.instagramui.domain.model.Content

@Composable
fun PostPreview(post: Post) {
    val url = when(val firstContent = post.contents.first()) {
        is Content.Image -> firstContent.url
        is Content.Video -> firstContent.url
    }
    AsyncImage(model = url, contentDescription = "")
}

@Composable
@Preview
fun PreviewPostPreview() {
    PostPreview(DummyData.users["uesaka_sumire"]!!.posts.first())
}