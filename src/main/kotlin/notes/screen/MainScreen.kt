package notes.screen

import notes.data.Archive
import notes.data.MenuItem

class MainScreen : BaseScreen("Список архивов") {

    private val list = mutableListOf<Archive>()

    override fun updateMenu() {
        menu.clear()
        menu.add(MenuItem("Выход") { onBackAction() })
        menu.add(MenuItem("Создать архив") { onCreateArchive() })
        for (archive in list) {
            menu.add(MenuItem(archive.name) { onSelectArchive(archive) })
        }
    }

    private fun onCreateArchive() {
        val title = userInteractor.requestString("Введите название нового архива: ")
        list.add(Archive(title))
        updateMenu()
    }

    private fun onSelectArchive(archive: Archive) {
        openScreen(ArchiveScreen(archive))
    }
}