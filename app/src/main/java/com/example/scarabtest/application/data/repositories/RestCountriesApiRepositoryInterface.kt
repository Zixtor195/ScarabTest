package com.example.scarabtest.application.data.repositories

import com.example.scarabtest.application.data.models.CountryModelResponse
import com.example.scarabtest.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface RestCountriesApiRepositoryInterface {
    suspend fun getCountriesByRegion(
        regionName: String,
    ): Flow<NetworkResult<List<CountryModelResponse>>>
}