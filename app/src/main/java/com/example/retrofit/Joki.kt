package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class Joki(
    @SerializedName("fallback")
    var fallback: String,
    @SerializedName("footer")
    var footer: String,
    @SerializedName("text")
    var text: String,
)
