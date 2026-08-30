# 🧭 Tourism Activity Management System 🌏

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/Tests-JUnit%204-25A162?style=flat-square&logo=junit5&logoColor=white)
![CLI](https://img.shields.io/badge/Interface-CLI-000000?style=flat-square)

A Java CLI app for managing tourism operators, their activities, and reviews across New Zealand. Create operators, add activities under them, and leave public, private, or expert reviews — all through simple terminal commands.

## How it works

Everything is driven from an interactive CLI: create an operator in a supported location, add activities under it, then leave public, private, or expert reviews on those activities.

| Command | Description |
| --- | --- |
| `CREATE_OPERATOR <OPERATOR_NAME> <LOCATION>` | Create a new operator in a supported location |
| `SEARCH_OPERATORS <KEYWORD>` | Search for operators by name or location |
| `VIEW_ACTIVITIES <OPERATOR_ID>` | View all activities offered by an operator |
| `CREATE_ACTIVITY <ACTIVITY_NAME> <ACTIVITY_TYPE> <OPERATOR_ID>` | Create a new activity under an operator |
| `SEARCH_ACTIVITIES <KEYWORD>` | Search activities by name, type, or location |
| `ADD_PUBLIC_REVIEW <ACTIVITY_ID>` | Add a public review |
| `ADD_PRIVATE_REVIEW <ACTIVITY_ID>` | Add a private review |
| `ADD_EXPERT_REVIEW <ACTIVITY_ID>` | Add an expert review |
| `DISPLAY_REVIEWS <ACTIVITY_ID>` | Display reviews for an activity |
| `ENDORSE_REVIEW <REVIEW_ID>` | Endorse a public review |
| `RESOLVE_REVIEW <REVIEW_ID> <RESPONSE>` | Resolve a private review |
| `UPLOAD_REVIEW_IMAGE <REVIEW_ID> <IMAGE_NAME>` | Upload an image for an expert review |
| `DISPLAY_TOP_ACTIVITIES` | Show the top activity in each location |
| `HELP` | Print available commands |
| `EXIT` | Exit the application |

## Getting started

**Prerequisites:** JDK 21, Maven (or use the bundled `mvnw` / `mvnw.cmd` wrapper).

```bash
# Windows
mvnw.cmd clean compile exec:java@run

# macOS / Linux
./mvnw clean compile exec:java@run
```

---

![ASC](https://i.imgur.com/KkTk2Lms.png) Rama Anumanchipalli
