package com.example.scarabtest.utils

import androidx.compose.runtime.MutableState

data class CountryListDataClass(
    val content: String,
    val selected: MutableState<Boolean>
) {
    fun toggle() {
        selected.value = !selected.value
    }

}
