package com.chapter.chapterkeep.model

data class BoardRankData(
    val imageResId: Int,
    val rank: Int,
    val postId: Long,
    val title: String,
    val likes: Int,
    val userName: String
)