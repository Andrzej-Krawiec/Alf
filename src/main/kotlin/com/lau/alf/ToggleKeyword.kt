package com.lau.alf

import com.intellij.lang.ASTNode
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.LangDataKeys

class ToggleKeyword : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)

        val toggleMutability = ToggleMutability(
            MutabilityKeywordFactory(),
            CmdProcessor(project!!)
        )

        val caretModel = editor.caretModel

        val file = e.getData(LangDataKeys.PSI_FILE)
        val element = file?.findElementAt(caretModel.offset)
        if (element is ASTNode) {
            val result = toggleMutability(element)
            println("DELETE ME: $result")
        }
    }
}