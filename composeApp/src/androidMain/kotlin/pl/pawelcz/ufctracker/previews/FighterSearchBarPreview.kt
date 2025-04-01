package pl.pawelcz.ufctracker.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pl.pawelcz.ufctracker.UFCTrackerTheme
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.components.FighterSearchBar

@Preview
@Composable
fun FighterSearchBarPreview() {
    UFCTrackerTheme(false) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            FighterSearchBar(
                searchQuery = "Alex Pereira",
                onSearchQueryChange = {},
                onImeSearch = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
