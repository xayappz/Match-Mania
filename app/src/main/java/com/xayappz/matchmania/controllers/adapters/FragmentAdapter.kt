package com.xayappz.matchmania.controllers.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xayappz.matchmania.models.Timeline
import com.xayappz.matchmania.views.MatchFragment

class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return Timeline.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return MatchFragment.newInstance(position)
    }

}