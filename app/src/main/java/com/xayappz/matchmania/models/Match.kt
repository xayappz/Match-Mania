package com.xayappz.matchmania.models

import com.google.gson.annotations.SerializedName


data class Match(
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf()

)
