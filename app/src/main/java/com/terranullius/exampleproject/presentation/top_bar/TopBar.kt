package com.terranullius.exampleproject.presentation.top_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(modifier: Modifier = Modifier, backgroundColor: Color = MaterialTheme.colors.primary) {

    TopAppBar(modifier = modifier, backgroundColor = backgroundColor) {
        var isSearching by remember {
            mutableStateOf(false)
        }
        when (isSearching) {
            true -> Unit
            else -> NonSearchContent {
                isSearching = true
            }
        }
    }
}

@Composable
private fun NonSearchContent(onSearchClick: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(horizontal = 6.dp)
    ) {

        Text(
            text = "Sharma Store",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Center
        )

        Row() {
            Icon(
                Icons.Outlined.Search,
                contentDescription = "",
                modifier = Modifier.clickable {
                    onSearchClick()
                })

            Spacer(modifier = Modifier.width(6.dp))

            Icon(
                Icons.Outlined.Settings,
                contentDescription = "",
                modifier = Modifier.clickable {
                    //TODO
                })
        }
    }
}