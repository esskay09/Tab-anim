package com.terranullius.exampleproject.presentation.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.terranullius.exampleproject.presentation.components.OptionsOverflowComposable
import com.terranullius.exampleproject.presentation.components.OverFlowAction

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NonSearchContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onSearchClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp, vertical = 8.dp)

        ) {
            Text(
                text = "Sharma Store",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = "",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier.clickable {
                        onSearchClick()
                    }.padding(6.dp))

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
