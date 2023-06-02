package templates

import org.json.JSONObject
import java.io.File

/** DirectoryTemplate
 *
 * A Directory Template contains all data needed to create it AND it's files.
 * Other than that, it is the same as a ProjectTemplate / FileTemplate.
 *
 */

@Suppress("unused", "MemberVisibilityCanBePrivate")
open class DirectoryTemplate (
    val name            : String,   // The name of the directory. E.g. "src"
    val location        : String,   // The location of the directory. E.g. "C:\\Users\\User\\Project"
    val subDirectories  : List<DirectoryTemplate>,
    val files           : List<FileTemplate>,
) {
    fun export(): String {
        val json = JSONObject()
        json.put("name", name)
        json.put("location", location)

        val subDirectoriesJSON = JSONObject()
        for (subDirectory in subDirectories) {
            subDirectoriesJSON.put(subDirectory.name, subDirectory.export())
        }

        val filesJSON = JSONObject()
        for (file in files) {
            filesJSON.put(file.name, file.export())
        }


        return json.toString(4)
    }

    fun createDirectory() {
        val directory = File(location, name)
        if (!directory.exists()) directory.mkdirs()

        for (subDirectory in subDirectories) {
            subDirectory.createDirectory()
        }

        for (file in files) {
            file.createFile(location)
        }
    }

    companion object {
        fun fromJSON(json: String): DirectoryTemplate {
            val jsonObject = JSONObject(json)
            val name = jsonObject.getString("name")
            val location = jsonObject.getString("location")

            val subDirectories = mutableListOf<DirectoryTemplate>()
            val subDirectoriesJSON = jsonObject.getJSONObject("subDirectories")
            for (key in subDirectoriesJSON.keys()) {
                subDirectories.add(fromJSON(subDirectoriesJSON.getString(key)))
            }

            val files = mutableListOf<FileTemplate>()
            val filesJSON = jsonObject.getJSONObject("files")
            for (key in filesJSON.keys()) {
                files.add(FileTemplate.fromJSON(filesJSON.getString(key), "$location\\$name"))
            }

            return DirectoryTemplate(name, location, subDirectories, files)
        }
    }
}