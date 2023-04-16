package id.shaderboi.instagramui.ui.main.reels

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun rememberReelsController(context: Context) = remember { ReelsController(context) }

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun Reels(content: @Composable (page: Int) -> Unit) {
//    val controller = rememberReelsController(LocalContext.current)
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)
//    LaunchedEffect(pagerState) {
//        snapshotFlow { pagerState.currentPage }.collect { page ->
////            controller.changePage(page)
//        }
//    }
    val pullRefreshState = rememberPullRefreshState(false, {
        coroutineScope.launch {
            pagerState.scrollToPage(0)
        }
    })
    VerticalPager(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState),
        pageCount = 10,
        state = pagerState,
        pageContent = content
    )
}