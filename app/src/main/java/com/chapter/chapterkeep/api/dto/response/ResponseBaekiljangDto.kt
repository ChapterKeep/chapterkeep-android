package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBaekiljangDto(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<BaekiljangData>
)

@Serializable
data class BaekiljangData(
    @SerialName("postId")
    val postId: Long,
    @SerialName("postTitle")
    val postTitle: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("likesCount")
    val likesCount: Long
)