package com.chapter.chapterkeep.api

import android.content.Context
import android.content.SharedPreferences

object TokenManager {
    private const val PREF_NAME = "chapterkeep_prefs"
    private const val TOKEN_KEY = "auth_token"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken(token: String) {
        prefs.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String? {
        val token = prefs.getString(TOKEN_KEY, null)
        return token
    }

    fun clearToken() {
        prefs.edit().remove(TOKEN_KEY).apply()
    }
}
