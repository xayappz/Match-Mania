package com.xayappz.matchmania.models

import com.google.gson.annotations.SerializedName


data class Limit (

  @SerializedName("id"           ) var id           : String?  = null,
  @SerializedName("name"         ) var name         : String?  = null,
  @SerializedName("baseCurrency" ) var baseCurrency : Boolean? = null,
  @SerializedName("preMinStake"  ) var preMinStake  : Int?     = null,
  @SerializedName("preMaxStake"  ) var preMaxStake  : Int?     = null,
  @SerializedName("preMaxPL"     ) var preMaxPL     : Int?     = null,
  @SerializedName("minStake"     ) var minStake     : Int?     = null,
  @SerializedName("maxStake"     ) var maxStake     : Int?     = null,
  @SerializedName("maxPL"        ) var maxPL        : Int?     = null,
  @SerializedName("delay"        ) var delay        : Int?     = null,
  @SerializedName("oddsLimit"    ) var oddsLimit    : Int?     = null

)