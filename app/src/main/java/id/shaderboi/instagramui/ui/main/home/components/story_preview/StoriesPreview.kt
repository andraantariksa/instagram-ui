package id.shaderboi.instagramui.ui.main.home.components.story_preview

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.shaderboi.instagramui.data.dummy.DummyData
import id.shaderboi.instagramui.domain.UserStory
import id.shaderboi.instagramui.ui.main.story.StoryActivity

@Composable
fun StoriesPreview() {
    val context = LocalContext.current
    val stories = DummyData.userStories
    val myUser = DummyData.users["uesaka_sumire"]!!
    val myUserStory = UserStory(
        contents = myUser.story,
        userBriefInfo = myUser.briefInfo.copy(username = "Your story"),
        false
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        item {
            StoryPreview(userStory = myUserStory, showAddButton = true, onClick = {
                val intent = Intent(context, StoryActivity::class.java).apply {
                    putExtra("STORY_INDEX", 0)
                }
                context.startActivity(intent)
            })
        }

        items(stories.size) { index ->
            val story = stories[index]
            StoryPreview(userStory = story, onClick = {
                val intent = Intent(context, StoryActivity::class.java).apply {
                    putExtra("STORY_INDEX", 0)
                }
                context.startActivity(intent)
            })
        }
    }
}

@Preview
@Composable
internal fun PreviewStories() {
    StoriesPreview()
}