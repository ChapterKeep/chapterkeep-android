package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchNickName(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<SearchNickNameData>
)

@Serializable
data class SearchNickNameData(
    @SerialName("nickname")
    val nickname: String,
    @SerialName("profileUrl")
    val profileUrl: String?,
    @SerialName("bookReviewCount")
    val bookReviewCount: Long
)

