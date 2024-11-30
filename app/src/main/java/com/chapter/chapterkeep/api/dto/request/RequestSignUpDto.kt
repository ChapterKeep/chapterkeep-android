package com.chapter.chapterkeep.api.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUpDto(
    @SerialName("info")
    val info: SignUpData,
//    @SerialName("profileImage")
//    val profileImage: SignUpImg
)

@Serializable
data class SignUpData(
    @SerialName("id")
    val id: String,
    @SerialName("password")
    val password: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("introduction")
    val introduction: String
)
