package id.shaderboi.instagramui.ui.main.profile.my

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import id.shaderboi.instagramui.ui.main.profile.my.contents.Posts
import id.shaderboi.instagramui.ui.main.profile.my.contents.Tagged
import id.shaderboi.instagramui.ui.main.profile.my.contents.Videos

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Contents() {
    HorizontalPager(count = 3) { page ->
        when(page) {
            0 -> Posts()
            1 -> Videos()
            2 -> Tagged()
            else -> throw IllegalStateException() // Unreachable
        }
    }
}