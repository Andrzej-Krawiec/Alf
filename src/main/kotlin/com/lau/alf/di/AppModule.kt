package com.lau.alf.di

import com.intellij.openapi.project.Project
import com.lau.alf.CmdProcessor
import com.lau.alf.actions.AlfredPanelCreator
import com.lau.alf.cmd.ToggleMutability
import com.lau.alf.cmd.mutability.MutabilityKeywordFactory
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

    @Provides
    fun provideAlfredPanelCreator(): AlfredPanelCreator =
        AlfredPanelCreator(project)
}