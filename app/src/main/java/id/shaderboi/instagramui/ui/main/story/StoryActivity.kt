package id.shaderboi.instagramui.ui.main.story

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.regular.CheckCircle
import compose.icons.fontawesomeicons.regular.Heart
import compose.icons.fontawesomeicons.regular.PaperPlane
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.Content
import id.shaderboi.instagramui.ui.theme.InstagramUITheme

class StoryActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val storyIndex = intent.getIntExtra("STORY_INDEX", 0)
        val userStory = DummyData.userStories[storyIndex]

        setContent {
            InstagramUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    val exoPlayer = remember(context) {
                        ExoPlayer.Builder(context).build()
                    }
                    val mediaSourceFactory = remember {
                        val dataSourceFactory = DefaultDataSourceFactory(
                            context,
                            Util.getUserAgent(context, context.packageName)
                        )
                        ProgressiveMediaSource.Factory(dataSourceFactory)
                    }

                    val pagerState = rememberPagerState()
                    LaunchedEffect(pagerState) {
                        // Collect from the pager state a snapshotFlow reading the currentPage
                        snapshotFlow { pagerState.currentPage }.collect { page ->
                            exoPlayer.stop()
                            exoPlayer.release()
                        }
                    }

                    val story = userStory.story
                    val storyContents = story.contents
                    val userBriefInfo = userStory.userBrief
                    Box {
                        HorizontalPager(count = storyContents.size) { page ->
                            when (val content = storyContents[page]) {
                                is Content.Image -> {
                                    AsyncImage(
                                        model = content.url,
                                        contentDescription = ""
                                    )
                                }
                                is Content.Video -> {
                                    LaunchedEffect(Unit) {
                                        exoPlayer.apply {
                                            val source =
                                                mediaSourceFactory
                                                    .createMediaSource(MediaItem.fromUri(content.url))
                                            prepare(source)
                                            playWhenReady = true
                                        }
                                    }

                                    DisposableEffect(
                                        AndroidView(
                                            factory = { context ->
                                                PlayerView(context).apply {
                                                    useController = false
                                                    player = exoPlayer
                                                }
                                            }
                                        )
                                    ) {
                                        onDispose {
                                            exoPlayer.release()
                                        }
                                    }
                                }
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
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
                                        model = userBriefInfo.imageUrl,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(32.dp)
                                            .clip(CircleShape)
                                    )
                                    Text(
                                        text = userBriefInfo.username,
                                        fontWeight = FontWeight.Bold
                                    )
                                    if (userBriefInfo.isOfficial) {
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
                                    modifier = Modifier
                                        .size(28.dp)
                                )
                            }
                            Row {
                                var message by remember { mutableStateOf("") }
                                TextField(
                                    value = message,
                                    onValueChange = { newMessage ->
                                        message = newMessage
                                    }
                                )
                                Icon(
                                    imageVector = FontAwesomeIcons.Regular.Heart,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(28.dp)
                                )
                                Icon(
                                    imageVector = FontAwesomeIcons.Regular.PaperPlane,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(28.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}