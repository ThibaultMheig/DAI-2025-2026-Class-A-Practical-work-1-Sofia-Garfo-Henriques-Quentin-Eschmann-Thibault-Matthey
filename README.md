# DAI-2025-2026-Class-A-Practical-work-1---Sofia-Garfo-Henriques-Quentin-Eschmann-Thibault-Matthey
Repository for the practical work 1 in the module DAI.
<br>
This project gives informations/stats about text files.

## Group members

This project has been made by:
- Thibault Matthey
- Sofia Garfo Henriques
- Quentin Eschmann


## Technical Specifications

### Java Version
- Java 17

### Dependencies
| Dependency | Version | Purpose |
|------------|---------|---------|
| PicoCLI | 4.7.6 | Command-line interface framework |

## Project Structure

The source code is organized as follows:

- [`src/main/java/ch/heigvd/project1/`](src/main/java/ch/heigvd/project1/) - Root package
- [`commands/`](src/main/java/ch/heigvd/project1/commands/) - Subcommand implementations and PicoCLI configuration
- [`ios/`](src/main/java/ch/heigvd/project1/ios/) - Input/output file handling utilities
- [`Main.java`](src/main/java/ch/heigvd/project1/Main.java) - Application entry point


## Installation and Usage

### Building
First you will have to compile the project. Here is a quick guide onhow to do it using maven.

1. Clone the repository
2. Navigate to the project root directory
3. Build using Maven:
```bash
mvn clean package
```

The compiled JAR will be available [here](target/project1-1.0-SNAPSHOT.jar) 

### Usage

This is how you run the project:
```bash
java -jar <compiled jar file> <path to input file> <output file name> <subcommand> [options]
```

\<compiled jar file\> is the path to the compile djar file created by maven. 
<br>
\<path to input file\> is the path to the input txt file.
<br>
\<output file name\> is the name for the output file. This file will be created where you run the project.
<br>
\<subcommand\> is one of the two subcommands of this project. stats and occurences.
<br>
[options] is used to give some more information to the program. It is not used in every command.

## Example

An example input file is present [here](src/test/java/ch/heigvd/project1/Input.txt).

### Stats

Provides statistics about your input file.
<br>
Example command:
```bash
java -jar target/project1-1.0-SNAPSHOT.jar ./Input.txt Output.txt stats
```
<br>
Example output:
<br>

```
Your text contains 325 characters.
Here is the number of occurrences for each letter:
25 a
14 b
...
12 z

Your text contains 57 words.
Your text contains 8 lines.
```




### Occurences

Provides information about occurences of a sequence of characters in your input file.
<br>

Example command:
```bash
java -jar target/project1-1.0-SNAPSHOT.jar ./Input.txt Output.txt occurences -w test
```
<br>

Example output:
```
There are 5 occurrences of the word "test". They are at positions: [12, 54, 128, 239, 301]
```

## Sources

- Github Copilot
- [StackOverflow](https://stackoverflow.com)
- [W3schools](https://w3schools.com)