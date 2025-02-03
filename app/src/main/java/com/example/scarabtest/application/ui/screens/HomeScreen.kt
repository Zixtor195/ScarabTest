package com.example.scarabtest.application.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.scarabtest.application.ui.widgets.LabelSelectorBar
import com.example.scarabtest.application.ui.widgets.MultiSelectorListWidget
import com.example.scarabtest.application.viewmodel.HomeScreenViewModel
import com.example.scarabtest.utils.Constants.REGION_LIST
import com.example.scarabtest.utils.CountryListDataClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, homeScreenViewModel: HomeScreenViewModel) {

    val countriesList: List<CountryListDataClass> by homeScreenViewModel.countriesList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFB2F0AD),
                    titleContentColor = Color(0xFF333333),
                ),
                title = {
                    Text("Small Top App Bar")
                }
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LabelSelectorBar(
                labelItems = REGION_LIST,
                backgroundColor = Color(0xFFB2F0AD),
                selectedBackgroundColor = Color(0xFF294D16),
                textColor = Color(0xFF333333),
                selectedTextColor = Color(0xFFD8D1D1),
                homeScreenViewModel = homeScreenViewModel
            )

            MultiSelectorListWidget(countriesList)
        }


    }


}