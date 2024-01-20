package org.company.app.data.settings

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

actual fun Settings(platform: Platform): Settings = PreferencesSettings(Preferences.userRoot())

actual class Platform