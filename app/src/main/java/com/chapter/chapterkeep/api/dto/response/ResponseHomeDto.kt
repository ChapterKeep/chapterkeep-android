package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeDto(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: HomeData
)

@Serializable
data class HomeData(
    @SerialName("bookShelfResDtoList")
    val bookShelfResDtoList: List<BookShelfData>,
    @SerialName("profileResDto")
    val profileResDto: ProfileData
)

@Serializable
data class ProfileData(
    @SerialName("nickname")
    val nickname: String,
    @SerialName("introduction")
    val introduction: String,
    @SerialName("profileUrl")
    val profileUrl: String?,
    @SerialName("visibility")
    val visibility: Boolean,
    @SerialName("postCount")
    val postCount: Long
)

@Serializable
data class BookShelfData(
    @SerialName("reviewId")
    val reviewId: Long,
    @SerialName("coverUrl")
    val coverUrl: String
)

