package com.alexmumo.starwars.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.starwars.models.People
import com.alexmumo.starwars.ui.viewmodels.PeopleViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: PeopleViewModel = getViewModel()
) {
    val people = remember {
        viewModel.people
    }.collectAsLazyPagingItems()

    val listState = rememberLazyListState()
    LazyColumn(
        state = listState
    ) {
        items(people.itemCount) { index ->
            people[index]?.let { people ->
                TextItem(people = people)
            }
        }
    }
}

@Composable
fun TextItem(people: People) {
    Text(
        text = people.name!!
    )
}
