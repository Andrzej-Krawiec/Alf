package com.lau.alf.di

import com.intellij.openapi.project.Project
import com.lau.alf.CmdProcessor
import com.lau.alf.MutabilityKeywordFactory
import com.lau.alf.ToggleMutability
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val project: Project
) {

    @Provides
    fun provideToggleMutability(
        factory: MutabilityKeywordFactory,
        processor: CmdProcessor
    ): ToggleMutability =
        ToggleMutability(factory, processor)


    @Provides
    fun provideMutabilityKeywordFactory(): MutabilityKeywordFactory =
        MutabilityKeywordFactory()

    @Provides
    fun provideCmdProcessor(): CmdProcessor =
        CmdProcessor(project)
}