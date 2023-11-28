package com.xayappz.matchmania.controllers.repository

import com.xayappz.matchmania.models.Data
import com.xayappz.matchmania.models.SportType

object SportTypeData {
    fun getMatchesDataCricket(list: List<Data>): ArrayList<Data> {
        val Cricket = mutableListOf<Data>()

        val finalMatchList = ArrayList<Data>()
        list.forEach {
            if (it.sportId?.toInt() == SportType.CRICKET.type) {
                Cricket.add(it)

            }
        }

        finalMatchList.addAll(Cricket)

        return finalMatchList
    }

    fun getMatchesDataTennis(list: MutableList<Data>): ArrayList<Data> {
        val Tennis = mutableListOf<Data>()

        val finalMatchList = ArrayList<Data>()
        list.forEach {
            if (it.sportId?.toInt() == SportType.TENNIS.type) {
                Tennis.add(it)

            }
        }

        finalMatchList.addAll(Tennis)

        return finalMatchList
    }

    fun getMatchesDataSoccer(list: MutableList<Data>): ArrayList<Data> {
        val Soccer = mutableListOf<Data>()

        val finalMatchList = ArrayList<Data>()
        list.forEach {
            if (it.sportId?.toInt() == SportType.SOCCER.type) {
                Soccer.add(it)

            }
        }

        finalMatchList.addAll(Soccer)

        return finalMatchList
    }


}