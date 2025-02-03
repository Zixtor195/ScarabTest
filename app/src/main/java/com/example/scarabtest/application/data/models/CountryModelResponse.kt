package com.example.scarabtest.application.data.models

import com.google.gson.annotations.SerializedName

class CountryModelResponse (
    @SerializedName("name") val  countryName: Name = Name(),
    @SerializedName("flags") val  countryFlags: Flags = Flags(),
)

class Name(
    @SerializedName("common") val commonName: String = "",
)

class Flags(
    @SerializedName("png") val pngFlag: String = "",
)