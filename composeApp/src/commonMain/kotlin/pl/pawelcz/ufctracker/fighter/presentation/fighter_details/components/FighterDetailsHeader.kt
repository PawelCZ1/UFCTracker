package pl.pawelcz.ufctracker.fighter.presentation.fighter_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import pl.pawelcz.ufctracker.fighter.domain.Fighter
import ufctracker.composeapp.generated.resources.Res
import ufctracker.composeapp.generated.resources.fighter_error

@Composable
fun FighterDetailsHeader(fighter: Fighter?) {
    Column(modifier = Modifier.wrapContentSize().padding(16.dp)) {
        Row {
            Column {
                Text(
                    text = fighter?.firstName  ?: "Unknown First Name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = fighter?.lastName  ?: "Unknown Last Name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = fighter?.category  ?: "Unknown Division",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                var imageLoadResult by remember {
                    mutableStateOf<Result<Painter>?>(null)
                }
                val painter = rememberAsyncImagePainter(
                    model = fighter?.imageUrl,
                    onSuccess = {
                        imageLoadResult = if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                            Result.success(it.painter)
                        } else {
                            Result.failure(Exception("Invalid image size"))
                        }
                    },
                    onError = {
                        it.result.throwable.printStackTrace()
                        imageLoadResult = Result.failure(it.result.throwable)
                    }
                )

                when (val result = imageLoadResult) {
                    null -> CircularProgressIndicator()
                    else -> {
                        Image(
                            painter = if (result.isSuccess) painter else painterResource(Res.drawable.fighter_error),
                            contentDescription = fighter?.id,
                            contentScale = if (result.isSuccess) {
                                ContentScale.Crop
                            } else {
                                ContentScale.Fit
                            },
                            modifier = Modifier.aspectRatio(
                                ratio = 0.65f,
                                matchHeightConstraintsFirst = true
                            )
                        )
                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
        Row {
            Text(
                text = "WINS: ${fighter?.wins ?: "0"}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "LOSSES: ${fighter?.losses ?: "0"}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "DRAWS: ${fighter?.draws ?: "0"}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}