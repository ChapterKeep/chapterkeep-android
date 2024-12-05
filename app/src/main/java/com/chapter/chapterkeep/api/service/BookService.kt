package com.chapter.chapterkeep.api.service

import com.chapter.chapterkeep.api.dto.response.ResponseBookReviewDto
import com.chapter.chapterkeep.api.dto.response.ResponseSearchNickName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookService {
    @GET("/book-review/{reviewId}")
    suspend fun getBookReview(
        @Path("reviewId") reviewId: Long
    ):Response<ResponseBookReviewDto>

    @GET("/search/book-shelf")
    suspend fun getSearchNickName(
        @Query("nickname") nickname: String
    ): Response<ResponseSearchNickName>
}