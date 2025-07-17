package com.panevrn.streamhub.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import com.panevrn.streamhub.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.panevrn.streamhub.ui.elements.TitleText


@Composable
fun MainScreenAuth(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: Весь остальной UI
        TitleText(
            text = stringResource(R.string.auth_title),
            modifier = Modifier.padding(top = 32.dp))
    }
}

