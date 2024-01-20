package org.company.app.di

import com.russhwolf.settings.Settings
import org.company.app.data.datastore.DataStore
import org.company.app.data.repository.RidesRepository
import org.company.app.data.settings.Platform
import org.company.app.data.settings.Settings
import org.koin.core.Koin
import org.koin.core.module.Module
import org.koin.dsl.module

lateinit var koin: Koin

fun platformModule(platform: Platform): Module {
    return module {
        single { platform }
    }
}

val commonModule = module {
    single<Settings> { Settings(platform = get()) }
    factory { DataStore(settings = get()) }
    factory { RidesRepository(dataStore = get()) }
}

