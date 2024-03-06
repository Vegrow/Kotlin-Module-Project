package notes.screen

import notes.NotesApp
import notes.data.MenuItem
import notes.io.UserInteractor
import java.io.PrintStream
import java.util.Scanner

abstract class BaseScreen(
    private val screenTitle: String
) {

    protected val userInteractor = UserInteractor(Scanner(System.`in`), PrintStream(System.out))
    protected var menu = mutableListOf<MenuItem>()
    private var isActive = true

    fun start() {
        updateMenu()
        isActive = true
        while (isActive) {
            userInteractor.printMessage("\n$screenTitle")
            userInteractor.printMenu(menu)
            val menuNumber = userInteractor.requestMenuNumber()
            if (isMenuNumberOk(menuNumber)) {
                handleMenuNumber(requireNotNull(menuNumber) { "Oooops, I did it again..." })
            } else {
                handleWrongMenuNumber(menuNumber)
            }
        }
    }

    fun stop() {
        isActive = false
    }

    abstract fun updateMenu()

    private fun isMenuNumberOk(choice: Int?) =
        !(choice == null || choice < 0 || choice >= menu.size)

    private fun handleMenuNumber(choice: Int) {
        menu[choice].onItemSelect.invoke()
    }

    private fun handleWrongMenuNumber(choice: Int?) {
        val message = if (choice == null) {
            "Дай мне цифру, человече!"
        } else {
            "Меню под такой цифрой нет, введите цифру из предложенных ниже: "
        }
        userInteractor.printMessage(message)
    }

    protected fun onBackAction() {
        NotesApp.closeCurrentScreen()
    }

    protected fun openScreen(screen: BaseScreen) {
        NotesApp.startNewScreen(screen)
    }
}