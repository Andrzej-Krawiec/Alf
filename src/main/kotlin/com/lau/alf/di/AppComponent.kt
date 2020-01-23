package com.lau.alf.di

import com.lau.alf.actions.RunAlfredAction
import com.lau.alf.actions.ToggleKeywordAction
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(action: ToggleKeywordAction)
    fun inject(action: RunAlfredAction)
}