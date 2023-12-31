package com.xayappz.matchmania.controllers

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xayappz.matchmania.models.Data
import com.xayappz.matchmania.models.Match
import com.xayappz.matchmania.models.SportType
import com.xayappz.matchmania.utils.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Request : ViewModel() {
    val response: SingleLiveEvent<Match> = SingleLiveEvent()
    val isComplete: MutableLiveData<Boolean> = MutableLiveData()
    val isError: MutableLiveData<Boolean> = MutableLiveData()
    var isCricket: Boolean = false
    var isSoccer: Boolean = false
    var isTennis: Boolean = false


    @SuppressLint("SuspiciousIndentation")
    fun fetchNow() {
        val rxAdapter = RxJava3CallAdapterFactory.create()
        val retrofit = Retrofit.Builder()
            .baseUrl(com.xayappz.matchmania.BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build()

        val fetchData = retrofit.create(ApiService::class.java)

        fetchData.getMatchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(fetchMatchData())
    }


    fun fetchMatchData(): Observer<Match> {
        return object : Observer<Match> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Match) {
                isComplete.value = false
                response.value = t
                isError.value = false
            }

            override fun onError(e: Throwable) {
                isError.value = true
                isComplete.value = false
            }

            override fun onComplete() {
                isError.value = false
                isComplete.value = true

            }
        }
    }

    fun getMatchesData(list: MutableList<Data>): MutableList<Data> {
        val Cricket = mutableListOf<Data>()
        val Tennis = mutableListOf<Data>()
        val Soocer = mutableListOf<Data>()
        val finalMatchList = mutableListOf<Data>()
        list.forEach {
            if (it.sportId?.toInt() == SportType.CRICKET.type) {
                isCricket = true
                Cricket.add(it)
            } else if (it.sportId?.toInt() == SportType.SOCCER.type) {
                isSoccer = true
                Soocer.add(it)
            } else {
                isTennis = true
                Tennis.add(it)
            }
        }

        finalMatchList.addAll(Cricket)
        finalMatchList.addAll(Tennis)
        finalMatchList.addAll(Soocer)
        return finalMatchList
    }


}