package com.lau.alf.cmd.mutability

import com.intellij.lang.ASTNode

class MutabilityKeywordFactory {

    fun create(node: ASTNode): MutabilityKeyword =
        with(node) {
            when {
                isVal() -> ValKeyword(node)
                isVar() -> VarKeyword(node)
                else -> throw IllegalArgumentException("Wrong type: $elementType")
            }
        }

    private fun ASTNode.isVal() =
        elementType.toString() == "val"

    private fun ASTNode.isVar() =
        elementType.toString() == "var"
}