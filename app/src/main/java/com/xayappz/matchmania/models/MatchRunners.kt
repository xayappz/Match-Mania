package com.xayappz.matchmania.models

import com.google.gson.annotations.SerializedName


data class MatchRunners (

  @SerializedName("selectionId" ) var selectionId : Int?    = null,
  @SerializedName("name"        ) var name        : String? = null

)