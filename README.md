
# Made by
Siddhant Barguje 
23BCE10113

# Campus Course & Registration System (CCRS)

Hey there! 👋 Welcome to my Java project, CCRS. If you’re looking for a practical way to learn Java, play with OOP, or just want a cool CLI app for campus management, you’re in the right place.

## What’s This All About?
CCRS (Campus Course & Registration System) is a console-based app that helps you manage students, courses, enrollments, grades, and more. It’s packed with modern Java features—think design patterns, lambdas, error handling, CSV import/export, and even backup utilities. Everything’s organized so you can easily find and learn from the code.

## How to Get Started
**You’ll need:**
- Java JDK 8 or newer (any recent version works)


**To compile all source files (recommended):**
```shell
javac -d bin src\edu\ccrs\cli\*.java src\edu\ccrs\config\*.java src\edu\ccrs\domain\*.java src\edu\ccrs\exception\*.java src\edu\ccrs\io\*.java src\edu\ccrs\service\*.java src\edu\ccrs\util\*.java
```

**Or just compile the main file:**
```shell
javac -d bin src/edu/ccrs/cli/Main.java
```

**To run it:**
```shell
java -cp bin edu.ccrs.cli.Main
```

**Want sample data?**
Just drop `students_sample.csv` and `courses_sample.csv` into your project folder. Use the menu to import them and you’ll have instant demo records to play with.

**Debugging with Assertions:**
Assertions are a great way to catch bugs while you test. To enable them, run:
```shell
java -ea -cp bin edu.ccrs.cli.Main
```

## Java’s Journey (Quick Version)
- Java 1.0: Applets, basic OOP
- Java 2: Collections, Swing
- Java 5: Generics, annotations, enums
- Java 8: Lambdas, Streams, Date/Time API
- Java 9+: Modules, JShell, var, records, text blocks

## Java Editions: What’s the Difference?
| Edition | Use Case         | Highlights                  |
|---------|------------------|----------------------------|
| ME      | Mobile/Embedded  | Lightweight, limited APIs  |
| SE      | Desktop/Server   | Full core APIs             |
| EE      | Enterprise/Web   | Advanced, distributed APIs |

## JDK, JRE, JVM—What Do They Mean?
- **JDK:** The full toolkit for building and running Java apps (compiler, JRE, tools)
- **JRE:** Just enough to run Java apps (no compiler)
- **JVM:** The engine that runs Java bytecode, making Java platform-independent

## Syllabus Topics & Where to Find Them
Here’s a quick guide to where you’ll see each concept in the code:

| Topic                  | Where to See It                |
|------------------------|-------------------------------|
| OOP Principles         | `Person`, `Student`, `Instructor`, `Course` |
| Design Patterns        | `AppConfig` (Singleton), `Course.Builder`   |
| CLI                    | `Main.java`                   |
| CSV Import/Export      | `CSVUtil.java`, CLI menu      |
| Backup                 | `BackupUtil.java`             |
| Exception Handling     | `exception` package           |
| Lambdas/Streams        | `GPAUtil.java`, `CCRMService.java` |
| Abstract/Polymorphism  | `Person.java`, `toString()` overrides |
| Inner/Nested Classes   | `Course.java`, `DemoDiamond.java` |
| Interface/Diamond      | `DemoDiamond.java`            |
| Arrays/Utilities       | `Arrays` in `CCRMService.java`|
| String Methods         | `CCRMService.java`            |
| Loops                  | `Main.java`, `CCRMService.java` |
| Primitive/Operators    | Comments/examples in `CCRMService.java` |

## Pro Tips
- Sample CSV files are ready—just import and start exploring!
- Enable assertions for extra safety while testing.
- If you run into trouble, check the error analysis or code comments for help.

Thanks for checking out my project. Hope you enjoy learning and hacking with CCRS!

