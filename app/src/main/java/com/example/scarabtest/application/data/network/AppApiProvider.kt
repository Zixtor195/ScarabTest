package com.example.scarabtest.application.data.network

import com.example.scarabtest.application.data.repositories.RestCountriesApiRepository
import com.example.scarabtest.application.data.repositories.RestCountriesApiRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppApiProvider {

    @Binds
    @Singleton
    abstract fun providerAutocompleteApiRepository(
        restCountriesApiRepository: RestCountriesApiRepository,
    ): RestCountriesApiRepositoryInterface


}