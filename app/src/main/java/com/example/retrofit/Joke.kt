package com.example.retrofit

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class Joke(
    @SerializedName("attachments")
    var attachments: List<Joki>,
    @SerializedName("response_type")
    var response_type: String,
    @SerializedName("username")
    var username: String,

)
