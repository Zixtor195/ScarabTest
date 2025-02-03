package com.example.scarabtest.utils.application

import android.content.Context
import com.example.scarabtest.application.data.api.RestCountriesApi
import com.example.scarabtest.utils.Constants.URL_COUNTRIES_API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseApplicationProvider {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("countries_api")
    fun provideRestCountriesApiRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_COUNTRIES_API)
            .client(provideHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideRestCountriesApiClient(
        @Named("countries_api") retrofit: Retrofit
    ): RestCountriesApi = retrofit.create(RestCountriesApi::class.java)

}