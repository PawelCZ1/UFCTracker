package pl.pawelcz.ufctracker.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pl.pawelcz.ufctracker.core.presentation.UFCTrackerTheme
import pl.pawelcz.ufctracker.fighter.domain.Fighter
import pl.pawelcz.ufctracker.fighter.presentation.fighter_list.components.FighterList

@Preview
@Composable
fun FighterListPreview(){
    val fighters = (1..100).map {
        Fighter(
            id = it.toString(),
            firstName = "Name $it",
            lastName = "Surname $it",
            nickname = if (it % 2 == 0) "Nickname $it" else "",
            category = "Lightweight Division",
            placeOfBirth = "Dagestan Republic, Russia",
            age = 32,
            height = 70.00,
            weight = 155.00,
            wins = 26,
            losses = 1,
            draws = 0,
            imageUrl = "",
            octagonDebut = "May. 23, 2015",
            trainsAt = "AKA (American Kickboxing Academy) San Jose",
            fightingStyle = "Sambo",
            status = "Active"
        )
    }
    UFCTrackerTheme(false) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            FighterList(
                fighters,
                onFighterClick = {}
            )
        }
    }
}
