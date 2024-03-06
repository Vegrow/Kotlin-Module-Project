package notes.screen

import notes.data.Archive
import notes.data.MenuItem
import notes.data.Note

class ArchiveScreen(
    private val archive: Archive
) : BaseScreen("Архив \"${archive.name}\"") {

    override fun updateMenu() {
        menu.clear()
        menu.add(MenuItem("Назад") { onBackAction() })
        menu.add(MenuItem("Создать заметку") { onCreateNote() })
        for (note in archive.list) {
            menu.add(MenuItem(note.name) { onSelectNote(note) })
        }
    }

    private fun onCreateNote() {
        val title = userInteractor.requestString("Введите название заметки: ")
        val content = userInteractor.requestString("Введите текст заметки: ")
        archive.list.add(Note(title, content))
        updateMenu()
    }

    private fun onSelectNote(note: Note) {
        openScreen(NoteScreen(note))
    }
}