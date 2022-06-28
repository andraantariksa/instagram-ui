package id.shaderboi.instagramui.ui.main.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Search
import id.shaderboi.instagramui.ui.common.components.TextField

@Composable
fun SearchTopAppBar() {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {

            },
            placeholder = {
                Text(text = "Search")
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
}

@Preview
@Composable
fun PreviewSearchTopAppBar() {

}