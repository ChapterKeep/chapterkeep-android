package com.chapter.chapterkeep.ui.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chapter.chapterkeep.ui.screen.boardScreen.BoardScreen
import com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen.AddBaekiljangScreen
import com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen.BaekiljangScreen
import com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen.ViewBaekiljangScreen
import com.chapter.chapterkeep.ui.screen.bookScreen.AddBookScreen
import com.chapter.chapterkeep.ui.screen.bookScreen.ViewBookScreen
import com.chapter.chapterkeep.ui.screen.homeScreen.EditProfileScreen
import com.chapter.chapterkeep.ui.screen.homeScreen.HomeScreen
import com.chapter.chapterkeep.ui.screen.homeScreen.HomeViewModel
import com.chapter.chapterkeep.ui.screen.loginScreen.LoginScreen
import com.chapter.chapterkeep.ui.screen.loginScreen.LoginViewModel
import com.chapter.chapterkeep.ui.screen.myScreen.MoreScreen
import com.chapter.chapterkeep.ui.screen.myScreen.MyScreen
import com.chapter.chapterkeep.ui.screen.searchScreen.SearchScreen
import com.chapter.chapterkeep.ui.screen.signupScreen.SignUpScreen_ID
import com.chapter.chapterkeep.ui.screen.signupScreen.SignUpScreen_NickName
import com.chapter.chapterkeep.ui.screen.signupScreen.SignUpViewModel
import com.chapter.chapterkeep.ui.screen.startScreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    val signUpViewModel: SignUpViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel()
    val loginViewModel: LoginViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.ViewBook.route) {
        // 초기 화면
        composable(route = Routes.Splash.route) { // 스플래시
            SplashScreen(navController)
        }
        composable(route = Routes.Login.route) { // 로그인
            LoginScreen(navController, loginViewModel)
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
            BoardScreen(navController)
        }
        composable(route = Routes.Search.route) { // 검색화면
            SearchScreen(navController)
        }
        composable(route = Routes.My.route) { // 마이페이지 화면
            MyScreen(navController)
        }

        // 디테일 화면 - 홈
        composable(route = Routes.EditProfile.route) { // 프로필 수정 화면
            EditProfileScreen(navController, homeViewModel)
        }
        composable(route = Routes.AddBook.route) { // 독서 기록 추가 화면
            AddBookScreen(navController)
        }
        composable(route = Routes.ViewBook.route) { // 독서 기록 조회 화면
            ViewBookScreen(navController, 1)
        }

        // 디테일 화면 - 게시판
        composable(route = Routes.Baekiljang.route) { // 백일장 게시판 화면
            BaekiljangScreen(navController)
        }
        composable(route = Routes.AddBaekiljang.route) { // 백일장 게시글 등록
            AddBaekiljangScreen(navController)
        }
        composable(route = Routes.ViewBaekiljang.route) { // 백일장 게시글 조회
            ViewBaekiljangScreen(navController)
        }

        // 디테일 화면 - 마이페이지
        composable(
            route = Routes.More.route,
            arguments = listOf(navArgument("type") { type = NavType.StringType })
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: ""
            MoreScreen(navController, type)
        }
    }
}