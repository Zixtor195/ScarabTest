package com.example.scarabtest.application.ui.widgets

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.scarabtest.utils.CountryListDataClass

@Composable
fun MultiSelectorListItem(
    dataClass: CountryListDataClass,
    textColor: Color = Color.Black,
    selectedTextColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterStart),
            text = dataClass.content,
            color = textColor
        )

        Checkbox(
            modifier = Modifier.align(Alignment.CenterEnd),
            checked = dataClass.selected.value,
            onCheckedChange = {
                dataClass.toggle()
            })
    }
}