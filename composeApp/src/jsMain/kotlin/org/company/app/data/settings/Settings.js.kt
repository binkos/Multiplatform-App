package org.company.app.data.settings

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings

actual fun Settings(platform: Platform): Settings = StorageSettings()

actual class Platform

object a{
    fun a(){

    }
}