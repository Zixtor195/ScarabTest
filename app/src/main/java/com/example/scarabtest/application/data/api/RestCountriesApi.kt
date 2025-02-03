package com.example.scarabtest.application.data.api

import com.example.scarabtest.application.data.models.CountryModelResponse
import com.example.scarabtest.utils.Constants.URL_GET_COUNTRIES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountriesApi {

    @GET("$URL_GET_COUNTRIES/{region_name}")
    suspend fun getCountriesByRegion(
        @Path("region_name") regionName: String,
    ): Response<List<CountryModelResponse>>
}