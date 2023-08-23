import utils.ScannerInput
import utils.ScannerInput.readNextInt
import utils.ScannerInput.readNextLine
fun main(args: Array<String>) {
    runMenu()
}

fun mainMenu() : Int {
    return ScannerInput.readNextInt(""" 
         > -------------------------------------
         > |          NOTE KEEPER APP          |
         > -------------------------------------
         > | NOTE MENU                         |
         > |   1) Add a note                   |
         > |   2) List notes                   |
         > |   3) Update a note                |
         > |   4) Delete a note                |
         > |   5) Archive a note               |
         > |   6) Search note(by description)  |
         > -------------------------------------
         > |   20) Save notes                  |
         > |   21) Load notes                  |
         > -------------------------------------
         > |   0) Exit                         |
         > -------------------------------------
         > ==>> """.trimMargin(">"))
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> addNote()
            2  -> listNotes()
            3  -> updateNote()
            4  -> deleteNote()
            5 -> archiveNote()
            6 -> searchNotes()
            20  -> save()
            21  -> load()
            0  -> exitApp()
            else -> println("Invalid option entered: ${option}")
        }
    } while (true)
}