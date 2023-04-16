package id.shaderboi.instagramui.ui.main.my_profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Th
import compose.icons.fontawesomeicons.solid.UserTag
import compose.icons.fontawesomeicons.solid.Video
import id.shaderboi.instagramui.domain.model.User
import id.shaderboi.instagramui.ui.main.my_profile.contents.Posts
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Contents(user: User) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val pages = remember {
        listOf(
            FontAwesomeIcons.Solid.Th,
            FontAwesomeIcons.Solid.Video,
            FontAwesomeIcons.Solid.UserTag,
        )
    }

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
//                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        },
    ) {
        pages.forEachIndexed { index, iconImageVector ->
            Tab(
                text = {
                    Icon(
                        imageVector = iconImageVector,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                },
            )
        }
    }
    HorizontalPager(
        pageCount = pages.size,
        state = pagerState
    ) { page ->
        when (page) {
            0 -> Posts(user.posts)
            1 -> Posts(user.posts)
            2 -> Posts(user.posts)
            else -> throw IllegalStateException() // Unreachable
        }
    }
}

@Preview
@Composable
fun PreviewContents() {
//    val user = DummyData.users[DummyData.myUsername]!!
//    Contents(user = user)
}