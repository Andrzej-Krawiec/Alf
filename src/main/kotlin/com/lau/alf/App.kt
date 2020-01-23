package com.lau.alf

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.lau.alf.di.AppComponent
import com.lau.alf.di.AppModule
import com.lau.alf.di.DaggerAppComponent

class App : StartupActivity {

    override fun runActivity(project: Project) {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(project))
            .build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}
