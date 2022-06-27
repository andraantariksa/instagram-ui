package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import coil.imageLoader
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
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
        modifier = modifier.pointerInput(Unit) {
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
    when (content) {
        is Content.Image -> {
            if (state != ResourceState.Error) {
                AsyncImage(
                    model = content.url,
                    contentDescription = "",
                    modifier = modifier,
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
        is Content.Video -> TODO()
    }
}