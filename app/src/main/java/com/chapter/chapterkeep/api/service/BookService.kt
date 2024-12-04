package com.chapter.chapterkeep.api.service

import com.chapter.chapterkeep.api.dto.response.ResponseBookReviewDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {
    @GET("/book-review/{reviewId}")
    suspend fun getBookReview(
        @Path("reviewId") reviewId: Long
    ):Response<ResponseBookReviewDto>
}