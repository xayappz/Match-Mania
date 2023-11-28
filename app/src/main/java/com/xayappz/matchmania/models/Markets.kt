package com.xayappz.matchmania.models

import com.google.gson.annotations.SerializedName


data class Markets (

  @SerializedName("marketId"   ) var marketId   : String?            = null,
  @SerializedName("marketName" ) var marketName : String?            = null,
  @SerializedName("runners"    ) var runners    : ArrayList<Runners> = arrayListOf(),
  @SerializedName("status"     ) var status     : Boolean?           = null,
  @SerializedName("limit"      ) var limit      : ArrayList<Limit>   = arrayListOf()

)