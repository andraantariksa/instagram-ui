package id.shaderboi.instagramui.ui.main.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.ui.main.components.HomeTopAppBar
import id.shaderboi.instagramui.ui.main.home.components.post.Post
import id.shaderboi.instagramui.ui.main.home.components.story_preview.StoriesPreview
import id.shaderboi.instagramui.ui.main.story.StoryActivity

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(bottom = paddingValues.calculateBottomPadding())
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .drawBehind {
                                val strokeWidth = with(density) { 1.dp.toPx() }
                                val y = size.height - strokeWidth / 2

                                drawLine(
                                    Color.LightGray,
                                    Offset(0f, y),
                                    Offset(size.width, y),
                                    strokeWidth
                                )
                            }
                            .padding(vertical = 10.dp)
                    ) {
                        val context = LocalContext.current
                        StoriesPreview() {
                            val intent = Intent(context, StoryActivity::class.java).apply {
                                putExtra("STORY_INDEX", 0)
                            }
                            context.startActivity(intent)
                        }
                    }
                }

                items(DummyData.posts.size) { index ->
                    val post = DummyData.posts[index]
                    Post(userPost = post)
                }
            }
        }
    )
}