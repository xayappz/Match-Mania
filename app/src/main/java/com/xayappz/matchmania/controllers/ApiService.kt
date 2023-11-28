package com.xayappz.matchmania.controllers

import com.xayappz.matchmania.models.Match
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("getLiveMatches")
    fun getMatchData(): Observable<Match>
}