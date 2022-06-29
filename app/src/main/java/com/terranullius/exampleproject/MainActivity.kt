package com.terranullius.exampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.terranullius.exampleproject.presentation.top_bar.TabsContent
import com.terranullius.exampleproject.presentation.top_bar.TopBar
import com.terranullius.exampleproject.presentation.theme.ExampleProjectTheme

@OptIn(ExperimentalPagerApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        val pagerState = rememberPagerState(initialPage = 1)
                        AnimatedVisibility(visible = pagerState.currentPage != 0 || pagerState.targetPage != 0) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                TopBar(
                                    modifier = Modifier.fillMaxWidth(),
                                    pagerState = pagerState
                                )
                            }
                        }
                        TabsContent(pagerState = pagerState, 4)
                    }
                }
            }
        }
    }
}



