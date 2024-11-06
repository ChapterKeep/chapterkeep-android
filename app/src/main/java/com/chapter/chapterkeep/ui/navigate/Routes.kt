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

    // 추가화면
    object EditProfile : Routes("EditProfile")
    object AddBook : Routes("AddBook")
    object ViewBook : Routes("ViewBook")

}