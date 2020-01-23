package com.lau.alf.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR
import com.lau.alf.App
import java.awt.BorderLayout
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.inject.Inject

class RunAlfredAction : AnAction() {

    @Inject lateinit var creator: AlfredPanelCreator

    override fun actionPerformed(e: AnActionEvent) {
        App.component.inject(this)
        val editor = e.getRequiredData(EDITOR)

        val panel = creator(editor)

        editor.component.add(panel, BorderLayout.SOUTH)
        editor.component.revalidate()
        panel.requestFocus()
        panel.addFocusListener(object : FocusListener {
            override fun focusLost(e: FocusEvent?) {
                editor.component.remove(panel)
            }

            override fun focusGained(e: FocusEvent?) {
            }
        })
    }
}