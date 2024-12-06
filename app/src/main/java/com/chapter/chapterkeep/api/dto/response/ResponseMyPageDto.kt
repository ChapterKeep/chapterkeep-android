package com.chapter.chapterkeep.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyPageDto(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: MyPageData
)

@Serializable
data class MyPageData(
    @SerialName("nickname")
    val nickname: String,
    @SerialName("postCount")
    val postCount: Long,
    @SerialName("myPosts")
    val myPosts: List<PostsData>,
    @SerialName("commentedPosts")
    val commentedPosts: List<PostsData>,
    @SerialName("likedPosts")
    val likedPosts: List<PostsData>
)

@Serializable
data class PostsData(
    @SerialName("title")
    val title: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("postId")
    val postId: Long
)