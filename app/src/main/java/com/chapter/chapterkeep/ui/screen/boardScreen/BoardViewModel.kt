import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.response.GetPostBoardData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BoardViewModel : ViewModel() {
    private val _boardData = MutableStateFlow<GetPostBoardData?>(null)
    val boardData: StateFlow<GetPostBoardData?> = _boardData

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchBoardData() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ServicePool.bookService.getPostBoard()
                if (response.isSuccessful) {
                    _boardData.value = response.body()?.data
                } else {
                    _errorMessage.value = "Failed to load data: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
