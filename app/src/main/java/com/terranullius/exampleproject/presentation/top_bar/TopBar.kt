package com.terranullius.exampleproject.presentation.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

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
            true -> SearchContent(modifier = Modifier.fillMaxWidth()) {
                isSearching = false
            }
            else -> NonSearchContent(modifier = Modifier.fillMaxWidth(), pagerState) {
                isSearching = true
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun NonSearchContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onSearchClick: () -> Unit = {}
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
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
        TabLayout(pagerState)
    }

}

@Composable
fun SearchContent(modifier: Modifier, onBackClick: () -> Unit) {

    var searchValue by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(Icons.Outlined.ArrowBack, contentDescription = "", modifier = Modifier.clickable {
                onBackClick()
            })

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchValue,
                onValueChange = { searchValue = it })
        }

        Text(
            text = "Placeholder data",
            modifier = Modifier.padding(vertical = 25.dp, horizontal = 10.dp)
        )
    }
}