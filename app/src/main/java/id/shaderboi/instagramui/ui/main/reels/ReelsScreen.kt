package id.shaderboi.instagramui.ui.main.reels

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.CommentDots
import compose.icons.fontawesomeicons.regular.PaperPlane
import compose.icons.fontawesomeicons.solid.*

data class Reel(
    val exoPlayer: ExoPlayer
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ReelsScreen() {
    val context = LocalContext.current
    val reels = remember {
        List(
            3
        ) {
            Reel(
                ExoPlayer.Builder(context).build().apply {
                    setMediaItem(MediaItem.fromUri("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/zachking/posts/1_1.mp4"))
                    playWhenReady = true
                    repeatMode = ExoPlayer.REPEAT_MODE_ALL
                    addListener(object : Player.Listener {
                        override fun onPlaybackStateChanged(playbackState: Int) {
                            super.onPlaybackStateChanged(playbackState)

                            when (playbackState) {
                                Player.STATE_BUFFERING -> {
//                                        state = ResourceState.Loading
                                }
                                Player.STATE_READY -> {
//                                        state = ResourceState.Loaded
                                }
                                else -> {}
                            }
                        }
                    })
                    prepare()
                    pause()
                }
            )
        }
    }
    val startPage = 0
    val pagerState = rememberPagerState(initialPage = startPage)
    LaunchedEffect(pagerState.currentPage) {
        reels[pagerState.currentPage].exoPlayer.play()
        reels.forEachIndexed { i, reel ->
            if (i != pagerState.currentPage) {
                reel.exoPlayer.pause()
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        IconButton(
            onClick = {

            },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Solid.Camera,
                contentDescription = "",
                modifier = Modifier.size(36.dp)
            )
        }
        pagerState.currentPage
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            count = Int.MAX_VALUE,
            state = pagerState
        ) { _page ->
            val page = (_page - startPage) % reels.size
            val reel = reels[page]
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                DisposableEffect(
                    AndroidView(
                        factory = {
                            StyledPlayerView(context).apply {
                                player = reel.exoPlayer
                                useController = false
                                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
//                                setOnClickListener { view ->
//                                    if (reel.exoPlayer.isPlaying) {
//                                        reel.exoPlayer.pause()
//                                    } else {
//                                        reel.exoPlayer.play()
//                                    }
//                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize(),
                    )
                ) {
                    onDispose {
//                        reel.exoPlayer.pause()
                    }
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column(
                            modifier = Modifier.weight(1F),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "",
                                    modifier = Modifier.size(36.dp)

                                )
                                Text("test abc123")
                                Button(
                                    onClick = {
                                    }
                                ) {
                                    Text("Follow")
                                }
                            }
                            Text("test abc123")
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(
                                    imageVector = FontAwesomeIcons.Solid.Music,
                                    contentDescription = "",
                                    modifier = Modifier.size(36.dp)
                                )
                                Text("blablablabla")
                                Icon(
                                    imageVector = FontAwesomeIcons.Solid.User,
                                    contentDescription = "",
                                    modifier = Modifier.size(36.dp)
                                )
                                Text("blablablabla")
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier.width(56.dp),
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.Heart,
                                contentDescription = "",
                                modifier = Modifier.size(36.dp)
                            )
                            Text("45.8k")
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.Comment,
                                contentDescription = "",
                                modifier = Modifier.size(36.dp)
                            )
                            Text("1,812")
                            Icon(
                                imageVector = FontAwesomeIcons.Regular.PaperPlane,
                                contentDescription = "",
                                modifier = Modifier.size(36.dp)
                            )
                            Icon(
                                imageVector = FontAwesomeIcons.Regular.CommentDots,
                                contentDescription = "",
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}