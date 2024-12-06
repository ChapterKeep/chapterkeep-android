import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object TokenManager {
    private const val PREF_NAME = "chapterkeep_prefs"
    private const val TOKEN_KEY = "auth_token"

    private lateinit var prefs: SharedPreferences
    private val _tokenStateFlow = MutableStateFlow<String?>(null)
    val tokenStateFlow: StateFlow<String?> get() = _tokenStateFlow

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        _tokenStateFlow.value = prefs.getString(TOKEN_KEY, null)
    }

    fun saveToken(token: String) {
        prefs.edit().putString(TOKEN_KEY, token).apply()
        _tokenStateFlow.value = token
    }

    fun getToken(): String? = prefs.getString(TOKEN_KEY, null)

    fun clearToken() {
        prefs.edit().remove(TOKEN_KEY).apply()
        _tokenStateFlow.value = null
    }
}