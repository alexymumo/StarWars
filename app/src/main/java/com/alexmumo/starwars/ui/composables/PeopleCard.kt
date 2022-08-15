package com.alexmumo.starwars.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alexmumo.starwars.models.People

@Composable
fun PeopleCard(
    people: People,
    modifier: Modifier = Modifier
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
                text = people.name!!
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                color = Color.Gray,
                text = people.birthYear!!
            )
        }
    }
}

@Composable
fun TextItem(people: People) {
    Text(
        text = people.name!!,
    )
}
