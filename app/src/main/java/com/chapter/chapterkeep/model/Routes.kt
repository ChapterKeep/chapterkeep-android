package com.chapter.chapterkeep.model

sealed class Routes(val route: String) {
    object Splash : Routes("Splash")
    object Login : Routes("Login")
    object Signup_ID : Routes("Signup_ID")
    object Signup_NickName : Routes("Signup_NickName")
    object Home : Routes("Home")
    object EditProfile : Routes("EditProfile")

}