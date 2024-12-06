package com.chapter.chapterkeep.api

import com.chapter.chapterkeep.BuildConfig
import com.chapter.chapterkeep.api.service.BookService
import com.chapter.chapterkeep.api.service.HomeService
import com.chapter.chapterkeep.api.service.MemberService
import com.chapter.chapterkeep.api.service.PostService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val authInterceptor = AuthInterceptor()

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val memberService = ApiFactory.create<MemberService>()
    val homeService = ApiFactory.create<HomeService>()
    val bookService = ApiFactory.create<BookService>()
    val postService = ApiFactory.create<PostService>()
}