package com.lau.alf.actions

import com.intellij.lang.ASTNode
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.lau.alf.App
import com.lau.alf.cmd.ToggleMutability
import javax.inject.Inject

class ToggleKeywordAction : AnAction() {

    @Inject lateinit var toggleMutability: ToggleMutability

    override fun actionPerformed(e: AnActionEvent) {
        App.component.inject(this)
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val caretModel = editor.caretModel

        val file = e.getData(LangDataKeys.PSI_FILE)
        val element = file?.findElementAt(caretModel.offset)
        if (element is ASTNode) {
            val result = toggleMutability(element)
            println("DELETE ME: $result")
        }
    }
}