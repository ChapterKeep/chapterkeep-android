package com.chapter.chapterkeep.api.service

import com.chapter.chapterkeep.api.dto.response.ResponseHomeDto
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("/home")
    suspend fun getHome():Response<ResponseHomeDto>
}