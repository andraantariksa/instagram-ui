package id.shaderboi.instagramui.ui.main.reels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
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
import compose.icons.fontawesomeicons.solid.Camera
import compose.icons.fontawesomeicons.solid.Comment
import compose.icons.fontawesomeicons.solid.Heart
import compose.icons.fontawesomeicons.solid.Music
import compose.icons.fontawesomeicons.solid.User

data class Reel(
    val exoPlayer: ExoPlayer
)

@Composable
fun ReelsScreen() {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/zachking/posts/1_1.mp4"))
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
//            prepare()
            pause()
        }
    }
//    LaunchedEffect(pagerState.currentPage) {
//        val page = (pagerState.currentPage - startPage) % reels.size
//        reels[page].exoPlayer.play()
//        reels.forEachIndexed { i, reel ->
//            if (i != page) {
//                reel.exoPlayer.pause()
//            }
//        }
//    }
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

        Reels { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                AndroidView(
                    factory = {
                        StyledPlayerView(context).apply {
                            player = exoPlayer
                            useController = false
                            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                            exoPlayer.apply {
                                setMediaItem(MediaItem.fromUri("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/zachking/posts/1_1.mp4"))
                                prepare()
                            }
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

//                val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
//                DisposableEffect(lifecycleOwner) {
//                    val lifecycle = lifecycleOwner.lifecycle
//                    val observer = LifecycleEventObserver { _, event ->
//                        when (event) {
//                            Lifecycle.Event.ON_PAUSE -> {
//                                exoPlayer.playWhenReady = false
//                            }
//
//                            Lifecycle.Event.ON_RESUME -> {
//                                exoPlayer.playWhenReady = true
//                            }
//
//                            Lifecycle.Event.ON_DESTROY -> {
//                                exoPlayer.run {
//                                    stop()
//                                    release()
//                                }
//                            }
//
//                            else -> {}
//                        }
//                    }
//                    lifecycle.addObserver(observer)
//                    onDispose {
//                        lifecycle.removeObserver(observer)
//                    }
//                }

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

@Preview
@Composable
fun PreviewReelsScreen() {
    ReelsScreen()
}
