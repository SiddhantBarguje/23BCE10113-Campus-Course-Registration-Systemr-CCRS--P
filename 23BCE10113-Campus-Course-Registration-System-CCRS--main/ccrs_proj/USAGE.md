# USAGE.md

## Quick Start

1. **Compile all source files (recommended):**
  ```shell
  javac -d bin src\edu\ccrs\cli\*.java src\edu\ccrs\config\*.java src\edu\ccrs\domain\*.java src\edu\ccrs\exception\*.java src\edu\ccrs\io\*.java src\edu\ccrs\service\*.java src\edu\ccrs\util\*.java
  ```

  Or, to compile just the main file:
  ```shell
  javac -d bin src/edu/ccrs/cli/Main.java
  ```

2. **Run the application:**
   ```shell
   java -cp bin edu.ccrs.cli.Main
   ```

3. **Import sample data:**
   - Place `students_sample.csv` and `courses_sample.csv` in your project folder.
   - Use the CLI menu option to import students and courses from these files.

## Sample Data Files

- **students_sample.csv**
  ```csv
  S1,Onkar,onkar@vitb.com,19
  S2,Mayank,mayank@vitb.com,20
  S3,Shreyash,shreyash@vitb.com,19
  S4,Divyanshu,divyanshu@vitb.com,20
  S5,Akhil,akhil@vitb.com,19
  S6,Sarang,sarang@vitb.com,20
  S7,Lovesh,lovesh@vitb.com,20
  S8,Rohit,rohit@vitb.com,19
  S9,Aryan,aryan@vitb.com,20
  S10,Sagar,sagar@vitb.com,19
  S11,Abhinav,abhinav@vitb.com,20
  ```

- **courses_sample.csv**
  ```csv
  TOC,Theory of Computation,4,I1
  JAVA,Java Programming,3,I2
  MATHS,Mathematics,3,I3
  DSA,Data Structures & Algorithms,4,I4
  CAO,Computer Architecture & Organization,4,I5
  DLD,Digital Logic Design,3,I6
  EEE,Electrical & Electronics Engineering,3,I7
  ALGEBRA,Algebra,3,I8
  ```

## Sample CLI Commands

- **Import students:**
  - Select "Import Students from CSV" in the menu and enter `students_sample.csv`.
- **Import courses:**
  - Select "Import Courses from CSV" in the menu and enter `courses_sample.csv`.
- **View all students/courses:**
  - Use the menu options to list all students or courses.
- **Enroll a student:**
  - Choose "Enroll Student" and follow the prompts.
- **Backup data:**
  - Select "Backup Data" to create a backup of current records.

---
For more details, see the main README.md.
