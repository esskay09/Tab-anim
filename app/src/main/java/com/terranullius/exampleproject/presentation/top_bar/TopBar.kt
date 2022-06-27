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
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary
            )

            Row() {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = "",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier.clickable {
                        onSearchClick()
                    })

                Spacer(modifier = Modifier.width(6.dp))

                OptionsOverflowComposable(
                    actions = remember {
                        List(4) {
                            OverFlowAction(name = "Option $it") {}
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        TabLayout(pagerState)
    }

}

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
                modifier = Modifier.clickable {
                    onBackClick()
                })

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