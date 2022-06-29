package com.terranullius.exampleproject.presentation.main_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.background(Color.White)) {
        items(40) {
            SimpleListItem(
                content = it,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun SimpleListItem(modifier: Modifier = Modifier, content: Int) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(0xFF0A87DA),
        contentColor = Color.White
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(vertical = 13.dp, horizontal = 25.dp)) {
            Text(text = "Item $content")
        }
    }
}