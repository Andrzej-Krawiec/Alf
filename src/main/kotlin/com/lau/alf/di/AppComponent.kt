package com.lau.alf.di

import com.lau.alf.ToggleKeyword
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(useCase: ToggleKeyword)
}