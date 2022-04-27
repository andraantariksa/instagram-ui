package id.shaderboi.instagramui.ui.home

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.DummyData
import id.shaderboi.instagramui.ui.components.InstagramBottomAppBar
import id.shaderboi.instagramui.ui.components.InstagramTopAppBar
import id.shaderboi.instagramui.ui.home.components.post.Post
import id.shaderboi.instagramui.ui.home.components.story.Stories

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            InstagramTopAppBar()
        },
        bottomBar = {
            InstagramBottomAppBar()
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
                        Stories()
                    }
                }

                items(DummyData.posts.size) { index ->
                    val post = DummyData.posts[index]
                    Post(post = post)
                }
            }
        }
    )
}