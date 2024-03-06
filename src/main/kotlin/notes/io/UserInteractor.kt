package notes.io

import notes.data.MenuItem
import java.io.PrintStream
import java.util.Scanner

class UserInteractor(
    private val scanner: Scanner,
    private val printStream: PrintStream,
) {

    fun requestString(requestToUser: String): String {
        printStream.print(requestToUser)
        var value: String
        while (true) {
            value = scanner.nextLine()
            if (value.isNotBlank()) {
                return value
            } else {
                printStream.print("Ошибка! Отсутствует текст! Повторите ввод: ")
            }
        }
    }

    fun requestMenuNumber(messageToAsk: String = "Ваш выбор: "): Int? {
        print(messageToAsk)
        return scanner.nextLine().toIntOrNull()
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun printMenu(menu: List<MenuItem>) {
        menu.forEachIndexed { index, menuItem ->
            println("$index. ${menuItem.title}")
        }
    }
}