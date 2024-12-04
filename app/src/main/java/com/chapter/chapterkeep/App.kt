package com.chapter.chapterkeep

import android.app.Application
import com.chapter.chapterkeep.api.TokenManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        TokenManager.init(this)
    }
}
