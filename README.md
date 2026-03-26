# 📌 Task Tracker CLI (Java)

A simple **Command Line Interface (CLI)** application to manage your daily tasks.
You can add, update, delete, and track the status of tasks using a JSON file for persistence.

---

🔗 Project Link

👉 https://github.com/divyadiksha/task-cli

---

## 🚀 Features

* ✅ Add a new task
* ✅ Update an existing task
* ✅ Delete a task
* ✅ Mark task as:

  * `todo`
  * `in-progress`
  * `done`
* ✅ List all tasks
* ✅ List tasks by status
* ✅ Persistent storage using JSON file

---

## 🛠️ Tech Stack

* Java (Core Java)
* Jackson (for JSON handling)
* Maven (dependency management)

---

## 📂 Project Structure

```
com.divya.taskcli
│
├── Main.java              # Entry point (CLI handling)
├── model/
│   └── Task.java         # Task entity
└── service/
    └── TaskService.java  # Business logic + file handling
```

---

## 📄 JSON Storage

Tasks are stored in a file:

```
tasks.json
```

Example:

```json
[
  {
    "id": 1,
    "description": "Buy groceries",
    "status": "todo",
    "createdAt": "2026-03-26T10:30:00",
    "updatedAt": "2026-03-26T10:30:00"
  }
]
```

---

## ⚙️ Setup & Run

### 1. Clone the repository

```
git clone <repo-url>
cd TaskTrackerCLI
```

---

### 2. Build project

```
mvn clean install
```

---

### 3. Run application

```
java com.divya.taskcli.Main <command>
```

---

## 📌 Usage

### ➕ Add Task

```
add "Buy groceries"
```

---

### 📝 Update Task

```
update 1 "Buy groceries and cook dinner"
```

---

### ❌ Delete Task

```
delete 1
```

---

### 🔄 Mark Task

```
mark-in-progress 1
mark-done 1
```

---

### 📋 List Tasks

```
list
```

---

### 📋 List by Status

```
list done
list todo
list in-progress
```

---

## ⚠️ Notes

* Tasks are stored locally in `tasks.json`
* IDs are auto-generated
* Uses ISO date-time format (`LocalDateTime`)
* Basic error handling included

---

## 📈 Future Improvements

* Better ID generation (handle deletions)
* Input validation
* Pretty CLI output
* Unit testing
* Docker support

---

## 🤝 Contributing

Feel free to fork this repo and improve it!

---

## 📜 License

This project is for learning purposes.
