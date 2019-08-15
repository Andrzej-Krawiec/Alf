package com.lau.alf

import com.intellij.lang.ASTNode
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.command.UndoConfirmationPolicy
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.KtPsiFactory

class CmdProcessor(
    private val project: Project
) {
    fun toVar(node: ASTNode) {
        CommandProcessor.getInstance().executeCommand(project, {
            ApplicationManager.getApplication().runWriteAction {
                val factory = KtPsiFactory(project, true)
                (node as PsiElement).replace(factory.createVarKeyword())
            }
        }, "Convert to var", UndoConfirmationPolicy.DO_NOT_REQUEST_CONFIRMATION)
    }

    fun toVal(node: ASTNode) {
        CommandProcessor.getInstance().executeCommand(project, {
            ApplicationManager.getApplication().runWriteAction {
                val factory = KtPsiFactory(project, true)
                (node as PsiElement).replace(factory.createValKeyword())
            }
        }, "Convert to val", UndoConfirmationPolicy.DO_NOT_REQUEST_CONFIRMATION)
    }
}