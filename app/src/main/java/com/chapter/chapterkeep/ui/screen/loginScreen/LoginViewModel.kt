package com.chapter.chapterkeep.ui.screen.loginScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var userID by mutableStateOf("")
    var userPassWord by mutableStateOf("")

    // 이 부분을 통해 로그인한 유저의 닉네임과 자기소개를 저장합니다.
    var userNickName by mutableStateOf("")
    var userMyself by mutableStateOf("")

    // 로그인 성공 시 계정 정보를 업데이트합니다.
    fun login(userID: String, password: String, onLoginSuccess: (String, String) -> Unit) {
        // 서버 통신을 통해 로그인 검증 로직 추가
        // 여기에 로그인 성공 여부를 확인하는 로직을 추가하고,
        // 성공 시 onLoginSuccess 콜백을 호출하여 닉네임과 자기소개 정보를 업데이트
        if (userID == "test" && password == "1234") { // 예시로 임의의 유저 정보를 사용
            userNickName = "고먐고먐미"
            userMyself = "로그인 계정 정보 확인."
            onLoginSuccess(userNickName, userMyself)
        }
    }

    fun updateUserId(id: String) {
        userID = id
    }

    fun updateUserPassword(password: String) {
        userPassWord = password
    }
}
