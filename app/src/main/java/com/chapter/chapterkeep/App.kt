package com.chapter.chapterkeep

import TokenManager
import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        TokenManager.init(this)
    }
}
