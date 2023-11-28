package com.xayappz.matchmania.models

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("marketIds") var marketIds: ArrayList<String> = arrayListOf(),
    @SerializedName("markets") var markets: ArrayList<Markets> = arrayListOf(),
    @SerializedName("mEventId") var mEventId: String? = null,
    @SerializedName("matchRunners") var matchRunners: ArrayList<MatchRunners> = arrayListOf(),
    @SerializedName("bmProvider") var bmProvider: String? = null,
    @SerializedName("fancyAType") var fancyAType: String? = null,
    @SerializedName("bbbFancy") var bbbFancy: String? = null,
    @SerializedName("addType") var addType: String? = null,
    @SerializedName("channelNo") var channelNo: String? = null,
    @SerializedName("mType") var mType: String? = null,
    @SerializedName("eventId") var eventId: String? = null,
    @SerializedName("eventName") var eventName: String? = null,
    @SerializedName("marketId") var marketId: String? = null,
    @SerializedName("marketName") var marketName: String? = null,
    @SerializedName("competitionId") var competitionId: String? = null,
    @SerializedName("competitionName") var competitionName: String? = null,
    @SerializedName("sportId") var sportId: String? = null,
    @SerializedName("sportName") var sportName: String? = null,
    @SerializedName("oddsProvider") var oddsProvider: String? = null,
    @SerializedName("fancyProvider") var fancyProvider: String? = null,
    @SerializedName("openDate") var openDate: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("isActive") var isActive: Boolean? = null,
    @SerializedName("isResult") var isResult: Boolean? = null,
    @SerializedName("__v") var _v: Int? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null,
    @SerializedName("unixDate") var unixDate: Int? = null

)
