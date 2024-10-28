package com.chapter.chapterkeep.ui.screen.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel(){
    var userNickName by mutableStateOf("")
    var userMyself by mutableStateOf("")
    var isNickNameAvailable by mutableStateOf(true)
    var isNickNameClicked by mutableStateOf(false)

    fun updateUserNickName(nickname: String) {
        userNickName = nickname
    }

    fun updateUserMyself(myself: String) {
        userMyself = myself
    }

    fun checkNickNameAvailability() {
        // 실제 서버 통신 로직 추가
        // 예시: userNickName를 서버로 보내서 중복 여부 확인 후, isNickNameAvailable 값을 업데이트
        isNickNameAvailable = userNickName != "abcd" // 예시로 임의의 닉네임 "existingNickName"은 중복 처리
        isNickNameClicked = true
    }
}