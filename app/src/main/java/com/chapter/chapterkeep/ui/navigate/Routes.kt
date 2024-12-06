package com.chapter.chapterkeep.ui.navigate

sealed class Routes(val route: String) {
    // 초기화면
    object Splash : Routes("Splash")
    object Login : Routes("Login")
    object Signup_ID : Routes("Signup_ID")
    object Signup_NickName : Routes("Signup_NickName")

    // 메인화면
    object Search : Routes("Search")
    object Home : Routes("Home")
    object Board : Routes("Board")
    object My : Routes("My")

    // 디테일 화면 - 홈
    object EditProfile : Routes("EditProfile")
    object AddBook : Routes("AddBook")
    object ViewBook : Routes("ViewBook")

    // 디테일 화면 - 게시판
    object Baekiljang : Routes("Baekiljang") // 백일장
    object AddBaekiljang : Routes("AddBaekiljang") // 백일장 게시글 등록
    object ViewBaekiljang : Routes("ViewBaekiljang/{postId}") { // 백일장 게시글 조회
        fun createRoute(postId: Long) = "ViewBaekiljang/$postId"
    }

    // 디테일 화면 - 마이페이지
    object More : Routes("more/{type}") {
        fun createRoute(type: String) = "more/$type"
    }
}