package com.example.scarabtest.application.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelSelectorItem(
    text: String = "",
    selected: Boolean = false,
    labelTextStyle: TextStyle = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    backgroundColor: Color = Color.White,
    selectedBackgroundColor: Color = Color.Black,
    textColor: Color = Color.Black,
    selectedTextColor: Color = Color.White,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .background(if (selected) selectedBackgroundColor else backgroundColor)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = text,
            color = if (selected) selectedTextColor else textColor,
            style = labelTextStyle
        )
    }
}