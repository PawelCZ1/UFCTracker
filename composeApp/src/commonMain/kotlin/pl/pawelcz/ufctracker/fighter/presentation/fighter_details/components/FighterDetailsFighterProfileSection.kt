package pl.pawelcz.ufctracker.fighter.presentation.fighter_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pawelcz.ufctracker.fighter.domain.Fighter

@Composable
fun FighterDetailsFighterProfileSection(
    fighter: Fighter?
) {
    Column(modifier = Modifier.padding(8.dp).fillMaxWidth().wrapContentHeight()) {
        Text(
            text = "FIGHTER PROFILE",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 4.dp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "FIGHTING STYLE",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = fighter?.fightingStyle ?: "Unknown",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = Color.White.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "TRAINS AT",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = fighter?.trainsAt ?: "Unknown",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.End
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = Color.White.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "STATUS",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = fighter?.status ?: "Unknown",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}
