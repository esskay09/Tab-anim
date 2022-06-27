package com.terranullius.exampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.google.accompanist.pager.*
import com.terranullius.exampleproject.presentation.top_bar.TopBar
import com.terranullius.exampleproject.ui.theme.ExampleProjectTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalUnitApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        val pagerState = rememberPagerState(pageCount = 4, initialPage = 1)

                        AnimatedVisibility(visible = pagerState.currentPage != 0) {

                            Column(modifier = Modifier.fillMaxWidth()) {
                                TopBar(modifier = Modifier.fillMaxWidth())
                                TabLayout(pagerState)
                            }
                        }

                        TabsContent(pagerState = pagerState)

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(pagerState: PagerState) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {

        Tabs(pagerState = pagerState)
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "icon",
        "Home",
        "Shopping",
        "Settings"
    )

    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {

        list.forEachIndexed { index, _ ->

            if (index == 0) Tab(
                selected = pagerState.currentPage == index,
                icon = {
                    Icon(Icons.Default.Home, contentDescription = "")
                },
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }) else {
                Tab(
                    text = {
                        Text(
                            list[index],
                            color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        TabContentScreen(data = "Welcome to Screen $page")
    }
}


@Composable
fun TabContentScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = data,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
