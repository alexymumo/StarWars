package com.alexmumo.starwars.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    
) {
    var text by remember { mutableStateOf(false) }
    /*Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {*/
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            "Search Characters"
        },
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .clickable { },
        shape = RoundedCornerShape(size = 8.dp),
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Text
        ),
        label = { Text(text = "Alex") },
        maxLines = 1,
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar()
}
