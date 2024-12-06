package com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.response.BaekiljangData
import com.chapter.chapterkeep.api.dto.response.DetailBaekiljangData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BaekiljangViewModel : ViewModel() {
    private val _baekiljangPosts = MutableStateFlow<List<BaekiljangData>>(emptyList())
    val baekiljangPosts: StateFlow<List<BaekiljangData>> = _baekiljangPosts.asStateFlow()

    private val _searchResults = MutableStateFlow<List<BaekiljangData>>(emptyList())
    val searchResults: StateFlow<List<BaekiljangData>> = _searchResults.asStateFlow()

    private val _detailBaekiljang = MutableStateFlow<DetailBaekiljangData?>(null)
    val detailBaekiljang: StateFlow<DetailBaekiljangData?> = _detailBaekiljang.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun fetchBaekiljangPosts() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ServicePool.postService.getBaekiljang()
                if (response.isSuccessful) {
                    response.body()?.data?.let { data ->
                        _baekiljangPosts.value = data
                    } ?: run {
                        _baekiljangPosts.value = emptyList()
                    }
                } else {
                    _errorMessage.value = "Failed to fetch posts: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun searchBaekiljangPosts(keyword: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ServicePool.postService.getSearchBaekiljang(keyword)
                if (response.isSuccessful) {
                    response.body()?.data?.let { data ->
                        _searchResults.value = data
                    } ?: run {
                        _searchResults.value = emptyList()
                    }
                } else {
                    _errorMessage.value = "Failed to fetch search results: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchDetailBaekiljang(postId: Long) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ServicePool.postService.getDetailBaekiljang(postId)
                if (response.isSuccessful) {
                    _detailBaekiljang.value = response.body()?.data
                } else {
                    _errorMessage.value = "Failed to fetch post details: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
