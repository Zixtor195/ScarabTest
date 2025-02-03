package com.example.scarabtest.application.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.scarabtest.application.data.models.CountryModelResponse
import com.example.scarabtest.application.usecase.GetCountriesByRegionUseCase
import com.example.scarabtest.utils.CountryListDataClass
import com.example.scarabtest.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getCountriesByRegion: GetCountriesByRegionUseCase,
    app: Application
) : AndroidViewModel(app) {

    private val _countriesByRegion: MutableLiveData<NetworkResult<List<CountryModelResponse>>> =
        MutableLiveData(NetworkResult.Loading())
    private val countriesByRegion: LiveData<NetworkResult<List<CountryModelResponse>>> =
        _countriesByRegion

    private val _countriesList = MutableStateFlow(emptyList<CountryListDataClass>())
    val countriesList: StateFlow<List<CountryListDataClass>> = _countriesList.asStateFlow()


    private fun getCountriesByRegion(regionName: String) {
        Log.i("regionName", regionName)
        viewModelScope.launch {
            _countriesByRegion.value = NetworkResult.Loading()
            getCountriesByRegion.invoke(regionName).collect { values ->
                _countriesByRegion.value = values

                when (countriesByRegion.value) {
                    is NetworkResult.Success -> {
                        val countriesList = arrayListOf<CountryListDataClass>()
                        countriesByRegion.value?.data?.let {
                            it.forEach { country ->
                                countriesList.add(
                                    CountryListDataClass(
                                        content = country.countryName.commonName,
                                        selected = mutableStateOf(false)
                                    )
                                )
                            }
                            countriesListModifier(countriesList)
                        }
                        Log.i("HomeScreenViewModel", "GetAutocompleteList Work on Success")
                    }

                    is NetworkResult.Loading -> {
                        Log.i("HomeScreenViewModel", "GetAutocompleteList Work on Loading")
                    }

                    is NetworkResult.Error -> {
                        countriesListModifier(emptyList())

                        Log.e(
                            "HomeScreenViewModel",
                            "GetAutocompleteList Work on error: " + countriesByRegion.value?.message
                        )
                    }
                }
            }
        }

    }

    private fun countriesListModifier(
        list: List<CountryListDataClass> = countriesList.value
    ) {
        _countriesList.value = list
    }

    fun onClickLabelSelectorItem(regionName: String) {
        getCountriesByRegion(regionName)
    }



}


