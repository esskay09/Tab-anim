package com.terranullius.exampleproject.presentation.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.terranullius.exampleproject.presentation.components.circularReveal
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    pagerState: PagerState
) {
    Box(
        modifier = modifier.background(
            backgroundColor
        )
    ) {
        var isSearching by remember {
            mutableStateOf(false)
        }

        var isNonSearchContentVisible by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = isSearching){
            isNonSearchContentVisible = if (isSearching) false
            else {
                delay(20L)
                true
            }
        }

        val offsetOfSearchIcon by remember {
            mutableStateOf(Offset(0.9f, 0.28f))
        }

        var searchContentSize by remember {
            mutableStateOf(IntSize(0, 0))
        }

        SearchContent(
            modifier = Modifier
                .fillMaxWidth()
                .circularReveal(visible = isSearching, revealFrom = offsetOfSearchIcon)
                .onSizeChanged {
                    searchContentSize = it
                }
                .background(
                    MaterialTheme.colors.secondary
                )
                .padding(top = 6.dp, start = 4.dp)
        ) {
            isSearching = false
        }

        if (isNonSearchContentVisible) Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(with(LocalDensity.current) { searchContentSize.height.toDp() })
                .background(MaterialTheme.colors.secondary)
        ) {
            NonSearchContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .padding(top = 4.dp),
                pagerState,
            ) {
                isSearching = true
            }
        }


    }
}


