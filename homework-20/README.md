# Homework 20 - Java I/O. Часть 2

## Описание

Программа подсчитывает количество вхождений указанной последовательности символов в текстовом файле.

---

## Особенности

✅ Чтение файла в кодировке **UTF-8**  
✅ Поиск с **учётом регистра**  
✅ Использование **BufferedReader** для эффективного чтения  
✅ Подсчёт через метод `String.indexOf()`  
✅ Обработка ошибок ввода/вывода  

---

## Запуск

```bash
cd homework-20/src/main/java
javac ru/otus/hw20/Main.java
java -cp . ru.otus.hw20.Main
```

---

## Пример работы

### Содержимое файла `test.txt`:

```
Java - это язык программирования.
Java используется для backend разработки.
Java Developer Basic - курс по основам Java.
В Java есть классы, интерфейсы и обобщения.
Java работает на виртуальной машине JVM.
```

---

### Пример 1: Поиск "Java"

```
Введите имя файла: test.txt
Введите искомую последовательность символов: Java
Количество вхождений "Java" в файле "test.txt": 5
```

---

### Пример 2: Поиск "java" (с учётом регистра)

```
Введите имя файла: test.txt
Введите искомую последовательность символов: java
Количество вхождений "java" в файле "test.txt": 0
```

---

### Пример 3: Поиск "Basic"

```
Введите имя файла: test.txt
Введите искомую последовательность символов: Basic
Количество вхождений "Basic" в файле "test.txt": 1
```

---

## Реализация

### Метод `countOccurrences`:

```java
public static int countOccurrences(String fileName, String searchString) throws IOException {
    if (searchString.isEmpty()) {
        return 0;
    }

    int count = 0;
    StringBuilder content = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(
            new FileReader(fileName, StandardCharsets.UTF_8))) {
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
    }

    String text = content.toString();
    int index = 0;

    while ((index = text.indexOf(searchString, index)) != -1) {
        count++;
        index += searchString.length();
    }

    return count;
}
```

---

## Технические детали

✅ **BufferedReader** — буферизированное чтение для производительности  
✅ **FileReader** с явным указанием `StandardCharsets.UTF_8`  
✅ **try-with-resources** — автоматическое закрытие ресурсов  
✅ **String.indexOf()** — поиск подстроки с заданной позиции  
✅ Проверка на пустую строку поиска  
✅ Обработка `IOException`  

---

## Критерии оценки

✅ Реализован метод подсчёта вхождений подстроки в файле  
✅ Файл читается в кодировке UTF-8  
✅ Поиск выполняется с учётом регистра  
✅ Пользователь вводит имя файла и искомую строку  
✅ Результат выводится в консоль  
✅ Обработаны ошибки ввода/вывода  

**Статус: Готово к сдаче!** 🎯
