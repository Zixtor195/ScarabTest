package com.example.scarabtest.application.usecase

import com.example.scarabtest.application.data.models.CountryModelResponse
import com.example.scarabtest.application.data.repositories.RestCountriesApiRepositoryInterface
import com.example.scarabtest.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesByRegionUseCase @Inject constructor(
    private val restCountriesApiRepository: RestCountriesApiRepositoryInterface,
) {

    suspend operator fun invoke(regionName: String): Flow<NetworkResult<List<CountryModelResponse>>> {
        return restCountriesApiRepository.getCountriesByRegion(regionName)
    }

}