package com.chapter.chapterkeep.api.service

import com.chapter.chapterkeep.api.dto.response.ResponseBaekiljangDto
import com.chapter.chapterkeep.api.dto.response.ResponseDetailBaekiljangDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {
    @GET("/post/essay")
    suspend fun getBaekiljang(): Response<ResponseBaekiljangDto>

    @GET("/post/essay/search")
    suspend fun getSearchBaekiljang(
        @Query("keyword") keyword: String
    ): Response<ResponseBaekiljangDto>

    @GET("/post/essay/{postId}")
    suspend fun getDetailBaekiljang(
        @Path("postId") postId: Long
    ): Response<ResponseDetailBaekiljangDto>
}