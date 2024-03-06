package notes.screen

import notes.data.MenuItem
import notes.data.Note

class NoteScreen(
    private val note: Note
) : BaseScreen("Заметка \"${note.name}\"") {

    override fun updateMenu() {
        menu.clear()
        menu.add(MenuItem("Назад") { onBackAction() })
        menu.add(MenuItem("Посмотреть текст заметки") { onShowNoteContent() })
    }

    private fun onShowNoteContent() {
        userInteractor.printMessage("Текст заметки: ${note.text}")
    }
}