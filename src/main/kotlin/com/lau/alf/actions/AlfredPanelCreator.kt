package com.lau.alf.actions

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.ui.layout.panel
import java.awt.Component

class AlfredPanelCreator(
    private val project: Project
) {

    operator fun invoke(editor: Editor): Component =
        panel {
            row {
                label("aaa")
                label("bbb")
                label("ccc")
            }
        }
}