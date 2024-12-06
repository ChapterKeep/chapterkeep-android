package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDetailBaekiljangDto(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: DetailBaekiljangData
)

@Serializable
data class DetailBaekiljangData(
    @SerialName("memberId")
    val memberId: Long,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("profileUrl")
    val profileUrl: String,
    @SerialName("postId")
    val postId: Long,
    @SerialName("postTitle")
    val postTitle: String,
    @SerialName("anonymous")
    val anonymous: Boolean,
    @SerialName("content")
    val content: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("modifiedAt")
    val modifiedAt: String,
    @SerialName("likesCount")
    val likesCount: Long
)