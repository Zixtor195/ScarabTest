package com.example.scarabtest.application.ui.widgets

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.scarabtest.application.viewmodel.HomeScreenViewModel
import com.example.scarabtest.utils.CountryListDataClass


@Composable
fun MultiSelectorListWidget(countryList: List<CountryListDataClass>) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        LazyColumn(
            state = rememberLazyListState(),
        ) {
            items(items = countryList) { item ->
                MultiSelectorListItem(dataClass = item)
            }
        }
    }

}