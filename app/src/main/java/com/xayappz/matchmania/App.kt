package com.xayappz.matchmania

import android.app.Application
import com.xayappz.matchmania.controllers.Request

class App : Application() {
    private var mainViewModel: com.xayappz.matchmania.controllers.Request =
        com.xayappz.matchmania.controllers.Request
    override fun onCreate() {
        super.onCreate()
        mainViewModel.fetchNow()
    }

}