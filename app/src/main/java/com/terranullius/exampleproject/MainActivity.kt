package com.terranullius.exampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.google.accompanist.pager.*
import com.terranullius.exampleproject.presentation.top_bar.TabContentScreen
import com.terranullius.exampleproject.presentation.top_bar.TabsContent
import com.terranullius.exampleproject.presentation.top_bar.TopBar
import com.terranullius.exampleproject.ui.theme.ExampleProjectTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
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
                                TopBar(modifier = Modifier.fillMaxWidth(), pagerState = pagerState)
                            }
                        }
                        TabsContent(pagerState = pagerState)
                    }
                }
            }
        }
    }
}



