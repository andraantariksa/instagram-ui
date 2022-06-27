package id.shaderboi.instagramui.ui.main.profile.my.contents

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData

@Composable
fun Posts() {
    val posts = remember { DummyData.users["uesaka_sumire"]!!.posts }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        content = {
            items(posts.size) { postIndex ->
                PostPreview(posts[postIndex])
            }
        }
    )
}