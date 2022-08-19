package com.alexmumo.starwars.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun DetailCard() {
    ConstraintLayout {
        val (card, overview, detail) = createRefs()
        Card(
            elevation = 10.dp,
            modifier = Modifier.fillMaxWidth().height(100.dp).constrainAs(card) {
                top.linkTo(parent.top, margin = 5.dp)
            }
        ) {
            Text(text = "Alex")
        }
    }
}
