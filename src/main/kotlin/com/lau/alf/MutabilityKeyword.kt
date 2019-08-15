package com.lau.alf

import com.intellij.lang.ASTNode

sealed class MutabilityKeyword(val node: ASTNode) {
    fun toggle(processor: CmdProcessor) =
        when (this) {
            is ValKeyword -> toVar(processor)
            is VarKeyword -> toVal(processor)
        }
}

class ValKeyword(node: ASTNode) : MutabilityKeyword(node) {
    fun toVar(processor: CmdProcessor) =
        processor.toVar(node)
}

class VarKeyword(node: ASTNode) : MutabilityKeyword(node) {
    fun toVal(processor: CmdProcessor) =
        processor.toVal(node)
}