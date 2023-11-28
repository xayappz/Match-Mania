package com.xayappz.matchmania.utils

import android.annotation.SuppressLint
import android.util.Log
import com.xayappz.matchmania.models.Data
import com.xayappz.matchmania.models.Timeline
import com.xayappz.matchmania.views.MainActivity
import java.text.SimpleDateFormat
import java.util.Date

object FilterDate {

    private val dateFormat: SimpleDateFormat
    private val currentDate: String
    val hashMap = hashMapOf<Int, Timeline>()
    private var pos: Int = 0

    init {
        dateFormat = SimpleDateFormat("MM/dd/yyyy")
        currentDate = dateFormat.format(Date())
    }

    fun getTimeline() {
        val filteredDates: List<Data> = MainActivity.matchDataFinal.filter {
            it.openDate != ""
        }

        filteredDates.forEach {
            dateFilter(it.openDate.toString().substringBefore(" "), pos++)
        }
        //   return dateFilter("")
    }

    @SuppressLint("NewApi", "SimpleDateFormat")
    fun dateFilter(date: String, pos: Int): HashMap<Int, Timeline> {
        Log.d("DATAAAAZ", date + " POS " + pos)
        val d1 = date
        val d2 = currentDate
        val firstDate: Date = dateFormat.parse(d1)
        val secondDate: Date = dateFormat.parse(d2)

        val cmp = firstDate.compareTo(secondDate)
        when {

            cmp > 0 -> {
                System.out.printf("%s is after %s", d1, d2)
                hashMap.put(pos, Timeline.Tomorrow)
                //tomorrow
            }

            cmp < 0 -> {
                System.out.printf("%s is before %s", d1, d2)
                hashMap.put(pos, Timeline.InPlay)
                //in-play

            }

            else -> {
                print("Both dates are equal")
                hashMap.put(pos, Timeline.Today)
                //today

            }
        }
        return hashMap
    }
}