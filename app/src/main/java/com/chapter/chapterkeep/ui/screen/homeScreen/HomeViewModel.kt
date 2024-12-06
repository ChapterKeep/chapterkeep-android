package com.chapter.chapterkeep.ui.screen.homeScreen

import TokenManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.response.BookShelfData
import com.chapter.chapterkeep.api.dto.response.ProfileData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var profileData by mutableStateOf(ProfileData("", "", null, false, 0))
    var bookShelfData by mutableStateOf(listOf<BookShelfData>())
    var isNickNameAvailable by mutableStateOf(true)
    var isNickNameClicked by mutableStateOf(false)

    init {
        observeTokenChanges()
    }

    private fun observeTokenChanges() {
        viewModelScope.launch {
            TokenManager.tokenStateFlow.collect { token ->
                if (token != null) {
                    fetchHomeData()
                }
            }
        }
    }

    fun fetchHomeData() {
        viewModelScope.launch {
            try {
                val response = ServicePool.homeService.getHome()
                if (response.isSuccessful) {
                    response.body()?.let {
                        profileData = it.data.profileResDto
                        bookShelfData = it.data.bookShelfResDtoList
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}