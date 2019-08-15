package com.lau.alf

import com.intellij.lang.ASTNode

class ToggleMutability(
    private val factory: MutabilityKeywordFactory,
    private val processor: CmdProcessor
) {

    operator fun invoke(node: ASTNode) =
        try {
            factory.create(node)
                .toggle(processor)
                .let { true }
        } catch (e: IllegalArgumentException) {
            false
        }
}