package com.alexmumo.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.starwars.R
import com.alexmumo.starwars.ui.composables.CharacterCard
import com.alexmumo.starwars.ui.viewmodels.CharacterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: CharacterViewModel = getViewModel()
) {
    val people = remember { viewModel.people }.collectAsLazyPagingItems()
    val listState = rememberLazyListState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            state = listState
        ) {
            items(people.itemCount) { index ->
                people[index]?.let { people ->
                    CharacterCard(character = people)
                }
            }
        }
    }
}
