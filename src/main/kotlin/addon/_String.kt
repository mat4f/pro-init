package addon

fun String.runAsRawProcess(inheritIO: Boolean = true): Process {
    val process = ProcessBuilder(*split(" ").toTypedArray()).start()
    if (inheritIO) {
        process.inputStream.copyTo(System.out)
        process.errorStream.copyTo(System.err)
    }
    process.waitFor()
    return process
}

fun String.runAsProcess(inheritIO: Boolean = true): Process {
    val process = ProcessBuilder("cmd", "/c", *split(" ").toTypedArray()).start()
    if (inheritIO) {
        process.inputStream.copyTo(System.out)
        process.errorStream.copyTo(System.err)
    }
    process.waitFor()
    return process
}