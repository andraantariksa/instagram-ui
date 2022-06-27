package id.shaderboi.instagramui.ui.main.home.components.story_preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.model.UserStory
import id.shaderboi.instagramui.domain.model.story.Story

@Composable
fun StoriesPreview(
    onClick: (userStory: UserStory) -> Unit
) {
    val stories = remember { DummyData.userStories }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        items(stories.size) { index ->
            val story = stories[index]
            StoryPreview(userStory = story) {
                onClick(story)
            }
        }
    }
}