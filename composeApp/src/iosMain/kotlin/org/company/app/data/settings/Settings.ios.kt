package org.company.app.data.settings

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

actual class Platform

actual fun Settings(platform: Platform): Settings {
    return NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
}