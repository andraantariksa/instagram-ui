package id.shaderboi.instagramui.ui.main.home.components.post

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Bookmark
import compose.icons.fontawesomeicons.regular.Comment
import compose.icons.fontawesomeicons.regular.Heart
import compose.icons.fontawesomeicons.regular.PaperPlane
import compose.icons.fontawesomeicons.solid.Bookmark
import compose.icons.fontawesomeicons.solid.Heart
import id.shaderboi.instagramui.ui.main.components.HorizontalPagerIndicator
import id.shaderboi.instagramui.ui.main.components.IconButton

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostBottomMenu(
    isMultipleContent: Boolean,
    pagerState: PagerState,
    isLiked: Boolean,
    onPressLike: () -> Unit
) {
    var isFavorited by remember { mutableStateOf(false) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .weight(1F),
        ) {
            val heartSize: Float by animateFloatAsState(
                if (isLiked) 1F else 0.2F,
                spring(Spring.DampingRatioHighBouncy)
            )
            IconButton(
                onClick = {
                    onPressLike()
                }
            ) {
                Icon(
                    imageVector = if (isLiked) {
                        FontAwesomeIcons.Solid.Heart
                    } else {
                        FontAwesomeIcons.Regular.Heart
                    },
                    contentDescription = "",
                    modifier = Modifier
                        .size(if (isLiked) postIconSize * heartSize else postIconSize),
                    tint = if (isLiked) {
                        Color.Red
                    } else {
                        LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                    }
                )
            }
            IconButton(
                onClick = {
                }
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Regular.Comment,
                    contentDescription = "",
                    modifier = postIconModifier
                )
            }
            IconButton(
                onClick = {
                }
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Regular.PaperPlane,
                    contentDescription = "",
                    modifier = postIconModifier
                )
            }
        }

        if (isMultipleContent) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1F),
                verticalAlignment = Alignment.Top
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Color(0F, 0.584F, 0.965F),
                    inactiveColor = Color(0.659F, 0.659F, 0.659F)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1F)
        ) {
            IconButton(
                onClick = {
                    isFavorited = !isFavorited
                }
            ) {
                Icon(
                    imageVector = if (isFavorited) {
                        FontAwesomeIcons.Solid.Bookmark
                    } else {
                        FontAwesomeIcons.Regular.Bookmark
                    },
                    contentDescription = "",
                    modifier = postIconModifier,
                )
            }
        }
    }
}