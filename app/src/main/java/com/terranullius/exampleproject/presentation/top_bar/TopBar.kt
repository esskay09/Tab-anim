package com.terranullius.exampleproject.presentation.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.terranullius.exampleproject.presentation.components.OptionsOverflowComposable
import com.terranullius.exampleproject.presentation.components.OverFlowAction

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    pagerState: PagerState
) {
    Column(
        modifier = modifier.background(
            backgroundColor
        )
    ) {
        var isSearching by remember {
            mutableStateOf(false)
        }
        when (isSearching) {
            true -> SearchContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colors.secondary
                    )
                    .padding(top = 6.dp, start = 4.dp)
            ) {
                isSearching = false
            }
            else -> NonSearchContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp), pagerState
            ) {
                isSearching = true
            }
        }
    }
}


