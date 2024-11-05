package com.chapter.chapterkeep.ui.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chapter.chapterkeep.ui.screen.bookScreen.AddBookScreen
import com.chapter.chapterkeep.ui.screen.homeScreen.EditProfileScreen
import com.chapter.chapterkeep.ui.screen.homeScreen.HomeScreen
import com.chapter.chapterkeep.ui.screen.homeScreen.HomeViewModel
import com.chapter.chapterkeep.ui.screen.loginScreen.LoginScreen
import com.chapter.chapterkeep.ui.screen.loginScreen.LoginViewModel
import com.chapter.chapterkeep.ui.screen.signupScreen.SignUpScreen_ID
import com.chapter.chapterkeep.ui.screen.signupScreen.SignUpScreen_NickName
import com.chapter.chapterkeep.ui.screen.signupScreen.SignUpViewModel
import com.chapter.chapterkeep.ui.screen.startScreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    val signUpViewModel: SignUpViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel()
    val loginViewModel: LoginViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.AddBook.route) {
        // 초기 화면
        composable(route = Routes.Splash.route) { // 스플래시
            SplashScreen(navController)
        }
        composable(route = Routes.Login.route) { // 로그인
            LoginScreen(navController, loginViewModel, homeViewModel)
        }
        composable(route = Routes.Signup_ID.route) { // 회원가입_아이디
            SignUpScreen_ID(navController, signUpViewModel)
        }
        composable(route = Routes.Signup_NickName.route) { // 회원가입_닉네임
            SignUpScreen_NickName(navController, signUpViewModel)
        }


        // 메인 화면
        composable(route = Routes.Home.route) { // 홈화면
            HomeScreen(navController, homeViewModel)
        }
        composable(route = Routes.Board.route) { // 게시판화면

        }
        composable(route = Routes.Search.route) { // 검색화면

        }
        composable(route = Routes.My.route) { // 마이페이지 화면

        }

        // 디테일 화면
        composable(route = Routes.EditProfile.route) { // 프로필 수정 화면
            EditProfileScreen(navController, homeViewModel)
        }
        composable(route = Routes.AddBook.route) { // 독서 기록 추가 화면
            AddBookScreen(navController)
        }
    }
}