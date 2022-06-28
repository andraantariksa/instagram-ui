package id.shaderboi.instagramui.ui.main.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.shaderboi.instagramui.ui.main.shop.components.ShopTopAppBar

@Composable
fun SearchScreen() {
    Scaffold(
        topBar = {
            ShopTopAppBar()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}