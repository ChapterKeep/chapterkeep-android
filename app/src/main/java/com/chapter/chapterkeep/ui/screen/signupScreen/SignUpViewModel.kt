package com.chapter.chapterkeep.ui.screen.signupScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

const val PASSWORD_MIN_LENGTH = 8
const val PASSWORD_MAX_LENGTH = 16
val PASSWORD_REGEX =
    Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{$PASSWORD_MIN_LENGTH,$PASSWORD_MAX_LENGTH}\$")

class SignUpViewModel : ViewModel() {
    var userID by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var userCheckPassword by mutableStateOf("")
    var userNickName by mutableStateOf("")
    var userMyself by mutableStateOf("")
    var isIDAvailable by mutableStateOf(true)
    var isNickNameAvailable by mutableStateOf(true)
    var isIDClicked by mutableStateOf(false)
    var isNickNameClicked by mutableStateOf(false)

    val isPasswordMatching: Boolean
        get() = userPassword == userCheckPassword

    val isIDInfoValid: Boolean
        get() = userID.isNotEmpty() && userPassword.isNotEmpty() && isPasswordMatching

    val isNickNameInfoValid: Boolean
        get() = userNickName.isNotEmpty() && userMyself.isNotEmpty()

    fun updateUserId(id: String) {
        userID = id
    }

    fun updateUserPassword(password: String) {
        userPassword = password
    }

    fun updateUserCheckPassword(checkpassword: String) {
        userCheckPassword = checkpassword
    }

    fun updateUserNickName(nickname: String) {
        userNickName = nickname
    }

    fun updateUserMyself(myself: String) {
        userMyself = myself
    }

    fun checkIDAvailability() {
        // 실제 서버 통신 로직 추가
        // 예시: userID를 서버로 보내서 중복 여부 확인 후, isIDAvailable 값을 업데이트
        isIDAvailable = userID != "ab" // 예시로 임의의 ID "existingID"는 중복 처리
        isIDClicked = true
    }

    fun checkNickNameAvailability() {
        // 실제 서버 통신 로직 추가
        // 예시: userNickName를 서버로 보내서 중복 여부 확인 후, isNickNameAvailable 값을 업데이트
        isNickNameAvailable = userNickName != "abcd" // 예시로 임의의 닉네임 "existingNickName"은 중복 처리
        isNickNameClicked = true
    }

    fun clearData() {
        userID = ""
        userPassword = ""
        userCheckPassword = ""
        userNickName = ""
        userMyself = ""
        isIDAvailable = true
        isNickNameAvailable = true
        isIDClicked = false
        isNickNameClicked = false
    }
}