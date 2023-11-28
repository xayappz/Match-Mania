package com.xayappz.matchmania.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xayappz.matchmania.controllers.adapters.MatchListAdapter
import com.xayappz.matchmania.controllers.repository.SportTypeData
import com.xayappz.matchmania.models.Data
import com.xayappz.matchmania.models.Timeline
import com.xayappz.matchmania.views.MainActivity
import io.reactivex.rxjava3.core.Observable


class AdapterHelper {
    val datas = mutableListOf<Data>()
    fun adapterSet(
        context: Context,
        recyclerView: RecyclerView,
        matchListRvSoccer: RecyclerView,
        matchListRvTennis: RecyclerView,
        dataState: Int,
        sporttypeCK: AppCompatTextView,
        sporttypeSC: AppCompatTextView,
        sporttypeTN: AppCompatTextView
    ) {
        datas.clear()
        val today = FilterDate.hashMap.filterValues {
            it.name == Timeline.Today.name
        }
        val inplay = FilterDate.hashMap.filterValues {
            it.name == Timeline.InPlay.name
        }
        val tomorrow = FilterDate.hashMap.filterValues {
            it.name == Timeline.Tomorrow.name
        }

        when (dataState) {
            0 -> {
                inplay.keys.forEach {
                    datas.add(MainActivity.matchDataFinal[it])
                }

            }

            1 -> {
                today.keys.forEach {
                    datas.add(MainActivity.matchDataFinal[it])
                }
            }

            2 -> {
                tomorrow.keys.forEach {
                    datas.add(MainActivity.matchDataFinal[it])
                }
            }
        }

        val Cricket = SportTypeData.getMatchesDataCricket(datas)
        val Tennis = SportTypeData.getMatchesDataTennis(datas)
        val Soccer = SportTypeData.getMatchesDataSoccer(datas)

        if (Cricket.size > 0) {
            sporttypeCK.visibility = View.VISIBLE
        }
        if (Tennis.size > 0) {
            sporttypeSC.visibility = View.VISIBLE
        }
        if (Soccer.size > 0) {
            sporttypeTN.visibility = View.VISIBLE

        }


        val matchAdapterCricket = MatchListAdapter(Cricket, dataState)
        recyclerView.adapter = matchAdapterCricket

        val matchAdapterSoccer = MatchListAdapter(Soccer, dataState)
        matchListRvSoccer.adapter = matchAdapterSoccer

        val matchAdapterTennis = MatchListAdapter(Tennis, dataState)
        matchListRvTennis.adapter = matchAdapterTennis

        matchAdapterCricket.onItemClick = { contact ->
            Toast.makeText(context, contact.eventName, Toast.LENGTH_SHORT).show()
        }
        matchAdapterTennis.onItemClick = { contact ->
            Toast.makeText(context, contact.eventName, Toast.LENGTH_SHORT).show()
        }
        matchAdapterSoccer.onItemClick = { contact ->
            Toast.makeText(context, contact.eventName, Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setItemViewCacheSize(Cricket.size);
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.setHasFixedSize(true)


        matchListRvTennis.layoutManager = LinearLayoutManager(context)
        matchListRvTennis.setItemViewCacheSize(Tennis.size);
        matchListRvTennis.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        matchListRvTennis.setHasFixedSize(true)

        matchListRvSoccer.layoutManager = LinearLayoutManager(context)
        matchListRvSoccer.setItemViewCacheSize(Soccer.size);
        matchListRvSoccer.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        matchListRvSoccer.setHasFixedSize(true)

    }
}