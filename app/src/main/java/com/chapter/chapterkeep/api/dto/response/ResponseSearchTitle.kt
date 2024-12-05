package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchTitle(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<SearchTitleData>
)

@Serializable
data class SearchTitleData(
    @SerialName("reviewTitle")
    val reviewTitle: String,
    @SerialName("coverUrl")
    val coverUrl: String,
    @SerialName("nickname")
    val nickname: String
)