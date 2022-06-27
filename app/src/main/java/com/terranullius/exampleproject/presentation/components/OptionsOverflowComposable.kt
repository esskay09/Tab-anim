package com.terranullius.exampleproject.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.terranullius.exampleproject.R

@Composable
fun OptionsOverflowComposable(
    actions: List<OverFlowAction> = listOf()
) {
    Box(contentAlignment = Alignment.Center) {
        var expanded by remember { mutableStateOf(false) }
        Icon(
            painter = painterResource(id = R.drawable.ic_overflow_options),
            contentDescription = "",
            modifier = Modifier
                .clickable {
//                    onClick()
                    expanded = true
                }
                .padding(6.dp),
            tint = MaterialTheme.colors.secondary
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            actions.forEach { action ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    action.onClick()
                }) {
                    Text(text = action.name)
                }
            }
        }
    }

}

data class OverFlowAction(
    val name: String,
    val onClick: () -> Unit
)