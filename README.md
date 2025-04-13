# MowItNow 🌱

**Automatic lawn mower simulator for rectangular grids**  

## 🛠️ Main Technologies

- Java 17
- Maven
- SLF4J + Logback for logging
- Hexagonal Architecture (Clean Architecture style)

---


## 🚀 How to Run the Application

### 🔧 Build the project

```bash
mvn clean package
```

This creates an executable JAR in the `target/` folder:

```
target/MowItNow-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## 📄 Input File Format

Example content:

```
5 5
1 2 N
LFLFLFLFF
3 3 E
FFRFFRFRRF
```

- First line: upper-right corner of the lawn grid (bottom-left is `0 0`)
- Then, for each mower:
    - One line with the initial position and orientation (e.g., `1 2 N`)
    - One line with movement instructions (`L`, `R`, `F`)

---

## 🏁 Run the Application

### ✅ 1. With a **file passed as argument**

```bash
java -jar target/MowItNow-1.0-SNAPSHOT-jar-with-dependencies.jar /path/to/input.txt
```

➡️ The file is read and parsed, and the mower instructions are executed.

---

### ✅ 2. Without any argument → uses the **default file**

```bash
java -jar target/MowItNow-1.0-SNAPSHOT-jar-with-dependencies.jar
```

➡️ In this case, the app falls back to:
```
src/main/resources/input.txt
```
