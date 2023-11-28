package com.xayappz.matchmania.views

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.xayappz.matchmania.R
import com.xayappz.matchmania.controllers.Request
import com.xayappz.matchmania.controllers.adapters.FragmentAdapter
import com.xayappz.matchmania.databinding.MainActivityBinding
import com.xayappz.matchmania.models.Data
import com.xayappz.matchmania.utils.FilterDate
import com.xayappz.matchmania.utils.UIHelper
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private var matchData = mutableListOf<Data>()
    private lateinit var navController: NavController
    private val viewModel: com.xayappz.matchmania.controllers.Request by viewModels()
    private lateinit var binding: MainActivityBinding

    companion object {
        var matchDataFinal = mutableListOf<Data>()
        var state: String = "STATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        binding = MainActivityBinding.inflate(layoutInflater);
        val view: View = binding.root
        setContentView(view)
        binding.viewPager.adapter = FragmentAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = baseContext.resources.getStringArray(R.array.tabs)[position]
        }.attach()
        loadData()
    }

    private fun loadData() {
        UIHelper.progressUI(this)
        UIHelper.showProgress()
        viewModel.isComplete.observe(this) {
            if (it) {
                UIHelper.hideProgress()
                matchDataFinal = viewModel.getMatchesData(matchData)
                FilterDate.getTimeline()
            }
        }
        viewModel.response.observe(this) {
            matchData.addAll(it.data)
        }
        viewModel.isError.observe(this) {
            if (it) {
                UIHelper.hideProgress()
                Snackbar.make(binding.root, "Some Error Occured", Snackbar.LENGTH_SHORT).show()

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}