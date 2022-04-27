package id.shaderboi.instagramui.ui.home.components.story

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.DummyData

@Composable
fun Stories() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(DummyData.userPreviews.size) { index ->
            val storyPreview = DummyData.userPreviews[index]
            Story(userPreview = storyPreview)
        }
    }
}