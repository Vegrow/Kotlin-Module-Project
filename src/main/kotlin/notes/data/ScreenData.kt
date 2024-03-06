package notes.data

data class Archive(
    val name: String,
    val list: MutableList<Note> = mutableListOf(),
)

data class Note(
    val name: String,
    val text: String,
)

data class MenuItem(
    val title: String,
    val onItemSelect: () -> Unit,
)