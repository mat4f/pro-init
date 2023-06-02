package main

import addon.runAsProcess
import console.Console
import templates.ProjectTemplate
import java.io.File

fun main(args: Array<String>) {
    var flags = args.filter { it.startsWith("--") }.map { it.removePrefix("--") }

    val dir: File
    if (flags.contains("dev")) {
        println("Detected --dev flag in program arguments. Running in development mode.")
        val selectedDir = Console.prompt("Please enter the path to the directory you would like to use", default = "C:\\Users\\Carl\\Desktop\\test")
        println("Selected Directory: '$selectedDir'")
        dir = File(selectedDir)
    } else {
        dir = File("./")
    }

    val templateLocation = File("%appdata%\\pro-init\\templates".replace("%appdata%", System.getenv("APPDATA")))
    val templateFiles = templateLocation.listFiles()?.filter { it.extension == "json" }
    if (templateFiles.isNullOrEmpty()) {
        println("No templates found. Please install a template from GitHub or other reliable sources.")
        return
    }

    val fileNames = templateFiles.map { it.nameWithoutExtension }
    val selectedTemplate = Console.promptMenu("Please select a template from the following list.", fileNames)

    println(dir.absolutePath)
    val template = ProjectTemplate.fromJSON( templateFiles[selectedTemplate - 1].readText(), dir )

    "cls".runAsProcess()

    template.createProject()
}