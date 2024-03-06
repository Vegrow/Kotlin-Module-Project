package notes

import notes.screen.BaseScreen
import notes.screen.MainScreen

object NotesApp {

    private val stack = ArrayDeque<BaseScreen>()

    init {
        stack.addLast(MainScreen())
        stack.last().start()
    }

    fun startNewScreen(screen: BaseScreen) {
        stack.lastOrNull()?.stop()
        stack.addLast(screen)
        screen.start()
    }

    fun closeCurrentScreen() {
        stack.removeLastOrNull()?.stop()
        stack.lastOrNull()?.start()
    }
}