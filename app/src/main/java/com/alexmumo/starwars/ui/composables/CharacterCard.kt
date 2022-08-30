package com.alexmumo.starwars.ui.composables

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
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(all = 5.dp)
    ) {
        Column {
            Row {
                Text(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    text = character.name!!
                )
            }
        }
    }
}
