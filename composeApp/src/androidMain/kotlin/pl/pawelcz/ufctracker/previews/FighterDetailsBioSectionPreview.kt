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
import pl.pawelcz.ufctracker.fighter.presentation.fighter_details.components.FighterDetailsBioSection

@Preview
@Composable
fun FighterDetailsBioSectionPreview() {
    val fighter = Fighter(
        id = "islam-makhachev",
        firstName = "Islam",
        lastName = "Makhachev",
        nickname = "",
        category = "Lightweight Division",
        placeOfBirth = "Dagestan Republic, Russia",
        age = 32,
        height = 70.00,
        weight = 155.00,
        wins = 26,
        losses = 1,
        draws = 0,
        imageUrl = "https://dmxg5wxfqgb4u.cloudfront.net/styles/athlete_bio_full_body/s3/2024-05/MAKHACHEV_ISLAM_L_BELT_06-01.png?itok=O8gDxptU",
        octagonDebut = "May. 23, 2015",
        trainsAt = "AKA (American Kickboxing Academy) San Jose",
        fightingStyle = "Sambo",
        status = "Active"
    )
    UFCTrackerTheme(false) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFC1121F).copy(0.2f))
        ) {
            FighterDetailsBioSection(fighter)
        }
    }
}