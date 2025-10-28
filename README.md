# Система управления библиотекой

Простая консольная система управления библиотекой на Java.

## Возможности
- Поиск книг по автору  
- Фильтрация по году издания  
- Сущности: `Author`, `Book`, `Reader`, `Library`

---

## Технологии
- **Java 17**  
- **Maven** и **Gradle** (многомодульные проекты)  
- **JUnit 5** + **JaCoCo**  
- **fat JAR** (`shade` / `shadow`)  
- **ZIP-архив**  
- **GitHub Packages** (публикация артефактов)

---

## Структура проекта
- **gradle-project/   → Gradle (core-module + cli-module)**
- **maven-project/    → Maven (parent-project + core-module + cli-module)**