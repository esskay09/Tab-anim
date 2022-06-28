package com.terranullius.exampleproject.presentation.top_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SearchContent(modifier: Modifier, onBackClick: () -> Unit) {

    var searchValue by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Outlined.ArrowBack,
                contentDescription = "",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .clickable {
                        onBackClick()
                    }
                    .padding(8.dp)
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchValue,
                placeholder = {
                    Text(text = "Search...", color = Color.Gray)
                },
                onValueChange = { searchValue = it },
                textStyle = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.primary
                )
            )
        }

        Text(
            text = "Placeholder data",
            modifier = Modifier.padding(vertical = 25.dp, horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Divider(thickness = 3.dp, color = Color.Gray)
    }
}