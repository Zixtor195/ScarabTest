package com.example.scarabtest.application.ui.widgets

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scarabtest.application.viewmodel.HomeScreenViewModel

@Composable
fun LabelSelectorBar(
    labelItems: List<String> = listOf(),
    labelTextStyle: TextStyle = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    backgroundColor: Color = Color.White,
    selectedBackgroundColor: Color = Color.Black,
    textColor: Color = Color.Black,
    selectedTextColor: Color = Color.White,
    homeScreenViewModel: HomeScreenViewModel
) {
    val selectedLabel = rememberSaveable { mutableStateOf(labelItems.firstOrNull() ?: "") }

    LazyRow(modifier = Modifier.height(80.dp)) {
        items(labelItems) { label ->
            LabelSelectorItem(
                text = label,
                selected = label == selectedLabel.value,
                labelTextStyle = labelTextStyle,
                backgroundColor = backgroundColor,
                selectedBackgroundColor = selectedBackgroundColor,
                textColor = textColor,
                selectedTextColor = selectedTextColor,
            ) {
                selectedLabel.value = label
                homeScreenViewModel.onClickLabelSelectorItem(label)
            }

        }
    }
}