package com.alexmumo.starwars.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.alexmumo.starwars.R
import com.alexmumo.starwars.data.cache.datastore.DatastoreManager.Companion.THEME_KEY
import com.alexmumo.starwars.ui.composables.CustomDialog
import com.alexmumo.starwars.ui.composables.CustomPreferenceGroup
import com.alexmumo.starwars.ui.composables.CustomTextPreference
import org.koin.androidx.compose.getViewModel

@Composable
fun SettingScreen(navController: NavController, paddingValues: PaddingValues, viewModel: SettingsViewModel = getViewModel()) {
    val currentTheme = viewModel.theme.collectAsState().value
    val showDialog = remember {
        mutableStateOf(false)
    }
    val themeLabel = stringArrayResource(id = R.array.labels)[currentTheme]

    Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
        CustomPreferenceGroup(
            title = stringResource(id = R.string.settings)
        ) {
            CustomTextPreference(
                icon = painterResource(id = R.drawable.splash),
                title = stringResource(id = R.string.settings),
                subTitle = themeLabel,
                onClick = { showDialog.value = !showDialog.value }
            )
            if (showDialog.value) SelectTheme(
                viewModel = viewModel,
                showDialog = showDialog,
                crrentValue = themeLabel
            )
        }
    }
}

@Composable
fun SelectTheme(
    viewModel: SettingsViewModel,
    showDialog: MutableState<Boolean>,
    crrentValue: String
) {
    CustomDialog(
        showDialog = showDialog.value,
        title = stringResource(id = R.string.detail),
        label = stringArrayResource(id = R.array.labels),
        onNegative = { showDialog.value = false }
    ) { theme ->
        viewModel.savePref(key = THEME_KEY, selection = theme)
    }
}
