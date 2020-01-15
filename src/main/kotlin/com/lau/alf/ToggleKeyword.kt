package com.lau.alf

import com.intellij.lang.ASTNode
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.lau.alf.di.AppModule
import com.lau.alf.di.DaggerAppComponent
import javax.inject.Inject

class ToggleKeyword : AnAction() {

    @Inject lateinit var toggleMutability: ToggleMutability

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)

        val caretModel = editor.caretModel

        DaggerAppComponent.builder()
            .appModule(AppModule(project!!))
            .build()
            .inject(this)

        val file = e.getData(LangDataKeys.PSI_FILE)
        val element = file?.findElementAt(caretModel.offset)
        if (element is ASTNode) {
            val result = toggleMutability(element)
            println("DELETE ME: $result")
        }
    }
}