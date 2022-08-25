package com.alexmumo.starwars.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexmumo.starwars.models.Character

@Composable
fun CharacterCard(
    character: Character,
    modifier: Modifier = Modifier,
) {
    var showDescription by remember { mutableStateOf(false) }
    val nameImageSize by animateDpAsState(targetValue = if (showDescription) 50.dp else 80.dp)
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .clickable { showDescription = showDescription.not() }
            .fillMaxWidth()
            .height(35.dp)
            .padding(all = 5.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .size(nameImageSize)
            ) {
                Text(
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp,
                    color = Color.Yellow,
                    text = character.name!!
                )
                Spacer(modifier = Modifier.fillMaxWidth())
                Text(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color.Gray,
                    text = character.birthYear!!
                )
                AnimatedVisibility(visible = showDescription) {
                    Text(
                        text = character.height!!,
                        color = Color.Blue,
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                    )
                }
            }
        }
    }
}

