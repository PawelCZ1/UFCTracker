package pl.pawelcz.ufctracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "UFC",
                color = MaterialTheme.colorScheme.secondary,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 96.sp
            )
            Spacer(modifier = Modifier.height(48.dp))
            val paddingModifier = Modifier.padding(10.dp)
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text("Fighters", modifier = paddingModifier)
//                Card(
//                    shape = RoundedCornerShape(8.dp),
//                    elevation = 10.dp, modifier = paddingModifier,
//                ) {
//                    Text(text = "Round corner shape", modifier = paddingModifier)
//                }
            }
        }
    }
}