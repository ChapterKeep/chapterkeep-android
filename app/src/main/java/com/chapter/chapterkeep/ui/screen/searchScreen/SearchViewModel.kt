package com.chapter.chapterkeep.ui.screen.searchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.response.SearchNickNameData
import com.chapter.chapterkeep.api.dto.response.SearchTitleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _profileResults = MutableStateFlow<List<SearchNickNameData>>(emptyList())
    val profileResults: StateFlow<List<SearchNickNameData>> = _profileResults.asStateFlow()

    private val _bookResults = MutableStateFlow<List<SearchTitleData>>(emptyList())
    val bookResults: StateFlow<List<SearchTitleData>> = _bookResults.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun searchByNickname(nickname: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ServicePool.bookService.getSearchNickName(nickname)
                if (response.isSuccessful) {
                    response.body()?.data?.let { data ->
                        _profileResults.value = data
                    } ?: run {
                        _profileResults.value = emptyList()
                    }
                } else {
                    _errorMessage.value = "Search failed: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun searchByTitle(title: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ServicePool.bookService.getSearchTitle(title)
                if (response.isSuccessful) {
                    response.body()?.data?.let { data ->
                        _bookResults.value = data
                    } ?: run {
                        _bookResults.value = emptyList()
                    }
                } else {
                    _errorMessage.value = "Search failed: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
