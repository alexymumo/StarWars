package com.alexmumo.starwars.ui.composables

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alexmumo.starwars.models.People

@Composable
fun PeopleCard(
    people: People,
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailCard(
    modifier: Modifier = Modifier,
    people: People,
    onItemClick: (People) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        onClick = { onItemClick(people) }
    ) {
        Text(
            text = people.name!!
        )
        Text(text = people.gender!!)
    }
}
