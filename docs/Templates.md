# Templates

## Template Syntax
Template files are written in JSON which means you do not
have to learn another complicated programming language. I
did not make any additions to the JSON syntax, so you can
use any JSON validator to check your template files.

## Template Structure
The template file is a JSON object with the following
properties:

| Property          | Type     | Description                         | Example                        |
|-------------------|----------|-------------------------------------|--------------------------------|
| `name`            | string   | The name of the project.            | `"Empty Node Project"`         |
| `version`         | string   | The version of the project.         | `"1.0.0"`                      |
| `author`          | string   | The author of the project.          | `"John Doe"`                   |
| `license`         | string   | The license of the project.         | `"MIT"`                        |
| `description`     | string   | The description of the project.     | `"An empty Node project."`     |
| `main`            | string   | The Main File of the project.       | `"index.js"`                   |
| `keywords`        | string[] | The keywords of the project.        | `["node", "empty", "project"]` |
| `dependencies`    | string[] | The dependencies of the project.    | `["express", "body-parser"]`   |
| `devDependencies` | string[] | The devDependencies of the project. | `["nodemon"]`                  |
| `scripts`         | object   | The scripts of the project.         | `{ "start": "node index.js" }` |
| `files`           | object[] | The files of the project.           | `["index.js", "package.json"]` |
| `directories`     | object[] | The directories of the project.     | `{ "src": "src" }`             |

### `files`
The `files` property has the following sub-properties:

| Property   | Type   | Description           | Example                          |
|------------|--------|-----------------------|----------------------------------|
| `name`     | string | The name of the file. | `"Empty Node Project"`           |
| `location` | string | The location of file. | `"src"`                          |
| `format`   | string | The format of file.   | `"typescript"`                   |
| `content`  | string | The content of file.  | `"console.log('Hello World!');"` |

### `directories`
The `directories` property has the following sub-properties:

| Property         | Type   | Description               | Example  |
|------------------|--------|---------------------------|----------|
| `name`           | string | The name of the directory | `"src"`  |
| `location`       | string | The location of directory | `"main"` |
| `files`          | object | The files of directory    | `{}`     |
| `subDirectories` | object | The children of directory | `{}`     |