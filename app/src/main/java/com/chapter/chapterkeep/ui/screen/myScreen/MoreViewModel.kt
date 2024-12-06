import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.response.PostsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoreViewModel : ViewModel() {
    private val _posts = MutableStateFlow<List<PostsData>>(emptyList())
    val posts: StateFlow<List<PostsData>> = _posts

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchPosts(type: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = when (type) {
                    "my_write" -> ServicePool.memberService.getMoreMyPosts()
                    "like_write" -> ServicePool.memberService.getMoreLikedPosts()
                    "comment_write" -> ServicePool.memberService.getMoreCommentedPosts()
                    else -> null
                }

                response?.let {
                    if (it.isSuccessful) {
                        _posts.value = it.body()?.data ?: emptyList()
                    } else {
                        _errorMessage.value = "Failed to fetch posts: ${it.message()}"
                    }
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
