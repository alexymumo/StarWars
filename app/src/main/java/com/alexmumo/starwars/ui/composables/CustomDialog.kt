package com.alexmumo.starwars.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.alexmumo.starwars.R
import java.util.*

@Composable
fun CustomDialog(
    showDialog: Boolean,
    title: String,
    currentValue: String? = null,
    label: Array<String>,
    onNegative: () -> Unit,
    onOptionSelected: (Int) -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onNegative() }) {
            Card(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = title,
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.onSurface,
                        fontSize = 22.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        label.forEachIndexed { index, option ->

                            CustomPreference(
                                optionText = option,
                                selectedOption = option == currentValue
                            ) {
                                onOptionSelected(index)
                                onNegative()
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            modifier = Modifier.clickable { onNegative() },
                            text = stringResource(id = R.string.cancel).uppercase(Locale.getDefault()),
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.primary,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
