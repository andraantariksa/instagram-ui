package id.shaderboi.instagramui.ui.main.shop.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Bookmark
import compose.icons.fontawesomeicons.solid.Bars
import compose.icons.fontawesomeicons.solid.Search
import id.shaderboi.instagramui.ui.common.components.Button
import id.shaderboi.instagramui.ui.common.components.TextField
import id.shaderboi.instagramui.ui.main.components.IconButton

@Composable
fun ShopTopAppBar() {
    val baseArrangement = Arrangement.spacedBy(12.dp)
    val horizontalPadding = 16.dp
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp),
        verticalArrangement = baseArrangement,
    ) {
        Column(
            verticalArrangement = baseArrangement,
            modifier = Modifier.padding(horizontal = horizontalPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Shop",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Regular.Bookmark,
                            contentDescription = ""
                        )
                    }
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.Bars,
                            contentDescription = ""
                        )
                    }
                }
            }
            TextField(
                value = "",
                onValueChange = {

                },
                placeholder = {
                    Text(text = "Search shops")
                },
                leadingIcon = {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Search,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true
            )
        }
        val sections = remember {
            listOf(
                "Shops",
                "Videos",
                "Editors pick",
                "Collections",
                "Guides",
                "Wishlist",
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = horizontalPadding)
        ) {
            items(sections) { item ->
                Button(
                    onClick = {}
                ) {
                    Text(item)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewShopTopAppBar() {
    ShopTopAppBar()
}