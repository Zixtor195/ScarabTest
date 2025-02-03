package com.example.scarabtest.application.data.repositories

import com.example.scarabtest.application.data.api.RestCountriesApi
import com.example.scarabtest.application.data.models.CountryModelResponse
import com.example.scarabtest.utils.BaseApiResponse
import com.example.scarabtest.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RestCountriesApiRepository @Inject constructor(
    private val restCountriesApi: RestCountriesApi
) : RestCountriesApiRepositoryInterface, BaseApiResponse() {

    override suspend fun getCountriesByRegion(
        regionName: String,
    ): Flow<NetworkResult<List<CountryModelResponse>>> {
        return flow {
            emit(safeApiCall {
                restCountriesApi.getCountriesByRegion(regionName)
            })
        }.flowOn(Dispatchers.IO)
    }
}