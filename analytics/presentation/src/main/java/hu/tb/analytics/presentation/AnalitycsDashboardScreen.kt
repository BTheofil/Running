@file:OptIn(ExperimentalMaterial3Api::class)

package hu.tb.analytics.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.tb.analytics.presentation.componenets.AnalyticsCard
import hu.tb.core.presentation.designsystem.RunningTheme
import hu.tb.core.presentation.designsystem.component.RunningScaffold
import hu.tb.core.presentation.designsystem.component.RunningToolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun AnalyticsDashboardScreenRoot(
    viewModel: AnalyticsDashboardViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    AnalyticsDashboardScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AnalyticsAction.OnBackClick -> onBackClick()
            }
        }
    )
}

@Composable
fun AnalyticsDashboardScreen(
    state: AnalyticsDashboardState?,
    onAction: (AnalyticsAction) -> Unit
) {
    RunningScaffold(
        topAppBar = {
            RunningToolbar(
                showBackButton = true,
                title = stringResource(R.string.analytics),
                onBackClick = {
                    onAction(AnalyticsAction.OnBackClick)
                }
            )
        }
    ) { padding ->
        if (state == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.total_distance_run),
                        value = state.totalDistanceRun
                    )
                    Spacer(Modifier.width(16.dp))
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.total_time_run),
                        value = state.totalTimeRun
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AnalyticsCard(
                        title = stringResource(id = R.string.fastest_ever_run),
                        value = state.fastestEverRun,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        title = stringResource(id = R.string.avg_distance_per_run),
                        value = state.avgDistance,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AnalyticsCard(
                        title = stringResource(id = R.string.avg_pace_per_run),
                        value = state.avgPace,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun AnalyticsDashboardScreenPreview() {
    RunningTheme {
        AnalyticsDashboardScreen(
            state = AnalyticsDashboardState(
                totalDistanceRun = "0.2km",
                totalTimeRun = "0d 0h 5m",
                fastestEverRun = "5 km/h",
                avgDistance = "0.1km",
                avgPace = "05:32"
            ),
            onAction = {}
        )
    }
}