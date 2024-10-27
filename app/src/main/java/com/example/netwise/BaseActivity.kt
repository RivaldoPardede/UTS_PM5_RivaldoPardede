import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.widget.ToggleButton

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No setupThemeToggle() here
    }

    protected fun setupThemeToggle(themeToggle: ToggleButton) {
        // Set the initial state of the toggle button based on current theme
        themeToggle.isChecked = isDarkTheme()

        // Set up listener for toggle button
        themeToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch to Dark Theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch to Light Theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    // Helper function to check if the dark theme is currently active
    private fun isDarkTheme(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }
}
