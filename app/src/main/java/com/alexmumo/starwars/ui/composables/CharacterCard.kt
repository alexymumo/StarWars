package com.alexmumo.starwars.ui.composables

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alexmumo.starwars.models.Character

@Composable
fun CharacterCard(
    character: Character,
    modifier: Modifier = Modifier,
    // onClickListener: (People) -> Unit
) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
    ) {
        Row {
            Text(
                color = Color.Blue,
                text = character.name!!
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                color = Color.Gray,
                text = character.birthYear!!
            )
        }
    }
}
