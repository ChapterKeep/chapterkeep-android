package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBookReviewDto(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: BookReviewData
)

@Serializable
data class BookReviewData(
    @SerialName("reviewId")
    val reviewId: Long,
    @SerialName("bookInfo")
    val bookInfo: BookInfoData,
    @SerialName("reviewTitle")
    val reviewTitle: String,
    @SerialName("rating")
    val rating: Int,
    @SerialName("quotation")
    val quotation: String?,
    @SerialName("content")
    val content: String,
    @SerialName("coverColor")
    val coverColor: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("modifiedAt")
    val modifiedAt: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("likesCount")
    val likesCount: Long
)

@Serializable
data class BookInfoData(
    @SerialName("title")
    val title: String,
    @SerialName("writer")
    val writer: String,
    @SerialName("coverUrl")
    val coverUrl: String
)