package com.alexmumo.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
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
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn(
                state = listState
            ) {
                items(people.itemCount) { index ->
                    people[index]?.let { people ->
                        CharacterCard(character = people)
                    }
                }
                people.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                        }
                        loadState.append is LoadState.Loading -> {
                        }
                        loadState.append is LoadState.Error -> {
                        }
                    }
                }
            }
        }
    }
}
