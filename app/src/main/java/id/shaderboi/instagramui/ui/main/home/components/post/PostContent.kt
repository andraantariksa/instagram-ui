package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.STATE_BUFFERING
import com.google.android.exoplayer2.Player.STATE_READY
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import id.shaderboi.instagramui.domain.model.Content
import id.shaderboi.instagramui.util.ResourceState

@Composable
fun PostContent(content: Content, onDoubleTap: () -> Unit) {
    var state by remember { mutableStateOf(ResourceState.Loading) }

    var modifier: Modifier = Modifier
    if (state == ResourceState.Loading || state == ResourceState.Error) {
        modifier = modifier
            .aspectRatio(1F)
    } else {
        // Loaded
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        onDoubleTap()
                    }
                )
            }
    }
    if (state == ResourceState.Loading) {
        modifier = modifier.placeholder(
            true,
            highlight = PlaceholderHighlight.shimmer(),
        )
    }
    if (state != ResourceState.Error) {
        when (content) {
            is Content.Image -> {
                AsyncImage(
                    model = content.url,
                    contentDescription = "",
                    modifier = modifier,
                    contentScale = ContentScale.FillWidth,
                    onLoading = { painter ->
                        state = ResourceState.Loading
                    },
                    onSuccess = { painter ->
                        state = ResourceState.Loaded
                    },
                    onError = { painter ->
                        state = ResourceState.Error
                    }
                )
            }
            is Content.Video -> {
                val context = LocalContext.current
                val exoPlayer = remember(context) {
                    ExoPlayer.Builder(context).build().apply {
                        setMediaItem(MediaItem.fromUri(content.url))
                        playWhenReady = true
                        repeatMode = ExoPlayer.REPEAT_MODE_ALL
                        addListener(object : Player.Listener {
                            override fun onPlaybackStateChanged(playbackState: Int) {
                                super.onPlaybackStateChanged(playbackState)

                                when (playbackState) {
                                    STATE_BUFFERING -> {
                                        state = ResourceState.Loading
                                    }
                                    STATE_READY -> {
                                        state = ResourceState.Loaded
                                    }
                                    else -> {}
                                }
                            }
                        })
                        prepare()
                    }
                }
                DisposableEffect(
                    AndroidView(
                        factory = { factoryContext ->
                            StyledPlayerView(context).apply {
                                player = exoPlayer
                                useController = false
                                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                                setOnClickListener { view ->
                                    if (exoPlayer.isPlaying) {
                                        exoPlayer.pause()
                                    } else {
                                        exoPlayer.play()
                                    }
                                }
                            }
                        },
                        modifier = modifier
                            .fillMaxSize(),
                    )
                ) {
                    onDispose {
                        exoPlayer.release()
                    }
                }
            }
        }
    } else {
        Column(
            modifier = modifier.clickable {
                state = ResourceState.Loading
            },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Couldn't load image. Tap to retry", textAlign = TextAlign.Center)
        }
    }
}