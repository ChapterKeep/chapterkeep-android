package com.chapter.chapterkeep.ui.screen.bookScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.response.BookReviewData
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ViewBookViewModel : ViewModel() {
    var bookTitle by mutableStateOf("")
        private set
    var bookWriter by mutableStateOf("")
        private set
    var coverUrl by mutableStateOf("")
        private set

    var reviewTitle by mutableStateOf("")
        private set
    var createdAt by mutableStateOf("")
        private set
    var starStates by mutableStateOf(listOf(false, false, false, false, false))
        private set
    var quotation by mutableStateOf("")
        private set
    var content by mutableStateOf("")
        private set
    var likeCounts by mutableStateOf(0)
        private set
    var nickname by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(true)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun fetchBookReview(reviewId: Long) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = ServicePool.bookService.getBookReview(reviewId)
                if (response.isSuccessful) {
                    response.body()?.data?.let { updateData(it) }
                } else {
                    errorMessage = "Failed to fetch book review: ${response.message()}"
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    private fun updateData(data: BookReviewData) {
        bookTitle = data.bookInfo.title
        bookWriter = data.bookInfo.writer
        coverUrl = data.bookInfo.coverUrl

        reviewTitle = data.reviewTitle
        createdAt = formatDate(data.createdAt)
        starStates = List(5) { index -> index < data.rating }
        quotation = data.quotation ?: ""
        content = data.content
        likeCounts = data.likesCount.toInt()
        nickname = data.nickname
    }

    private fun formatDate(isoDate: String): String {
        return try {
            val parsedDate = LocalDateTime.parse(isoDate, DateTimeFormatter.ISO_DATE_TIME)
            parsedDate.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"))
        } catch (e: Exception) {
            isoDate
        }
    }
}