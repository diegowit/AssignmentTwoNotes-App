// import controllers.NoteAPI
// import models.Note
import mu.KotlinLogging
// import persistence.JSONSerializer
// import utils.CategoryUtility
// import utils.ValidateInput.readValidCategory
// import utils.ValidateInput.readValidPriority
import java.io.File
import java.lang.System.exit
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



fun addNote(){

    val noteTitle = readNextLine("Enter a title for the note: ")
    val notePriority = readValidPriority("Enter a priority (1-low, 2, 3, 4, 5-high): ")
    val noteCategory = readValidCategory("Enter a category for the note from ${CategoryUtility.categories}: ")
    val isAdded = noteAPI.add(Note(noteTitle, notePriority, noteCategory, false))

    if (isAdded) {
        println("Added Successfully")
    } else {
        println("Add Failed")
    }
}





fun listNotes(){
    if (noteAPI.numberOfNotes() > 0) {
        val option = readNextInt(
            """
                  > --------------------------------
                  > |   1) View ALL notes          |
                  > |   2) View ACTIVE notes       |
                  > |   3) View ARCHIVED notes     |
                  > --------------------------------
         > ==>> """.trimMargin(">"))

        when (option) {
            1 -> listAllNotes();
            2 -> listActiveNotes();
            3 -> listArchivedNotes();
            else -> println("Invalid option entered: " + option);
        }
    } else {
        println("Option Invalid - No notes stored");
    }
}

fun listAllNotes() {
    println(noteAPI.listAllNotes())
}

fun listActiveNotes() {
    println(noteAPI.listActiveNotes())
}

fun listArchivedNotes() {
    println(noteAPI.listArchivedNotes())
}
