package org.company.app.data.settings

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

actual fun Settings(platform: Platform): Settings {
    // Match the behavior of PreferenceManager.getDefaultSharedPreferences(), without AndroidX lib or deprecated API
    val preferencesName = "${platform.context.packageName}_preferences"
    val delegate = platform.context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    return SharedPreferencesSettings(delegate)
}

actual data class Platform(
    val context: Context
)