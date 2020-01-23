package com.lau.alf.cmd

import com.intellij.lang.ASTNode
import com.lau.alf.CmdProcessor
import com.lau.alf.cmd.mutability.MutabilityKeywordFactory

class ToggleMutability(
    private val factory: MutabilityKeywordFactory,
    private val processor: CmdProcessor
) : Cmd<ASTNode> {

    override operator fun invoke(payload: ASTNode): Boolean =
        factory.create(payload)
            .toggle(processor)
            .let { true }

    override fun isSatisfiedBy(payload: ASTNode): Boolean =
        
}