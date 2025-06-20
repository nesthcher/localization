# Localization

Библиотека для управления локализацией сообщений и поддержкой различных языков в Java-приложениях.

> [!IMPORTANT]\
> Данный проект создается исключительно в целях проверки и улучшения навыков. Его использование в продакшен-версиях не рекомендуется, так как код может содержать нестабильные или неоптимизированные решения. Если у вас есть время и желание помочь в развитии проекта, я буду рад любым замечаниям и критике. Все идеи и предложения по улучшению приветствуются — они помогут сделать проект лучше!

## Обзор

Эта библиотека позволяет централизованно управлять локализованными сообщениями, загружать их из файлов или по URL, а также получать сообщения на нужном языке с поддержкой fallback на язык по умолчанию. Поддерживается работа с массивами сообщений и расширяемая система языков.

## Функции

-   Загрузка локалей из файлов и веб-ресурсов (JSON).
-   Унифицированный API для получения сообщений по ключу и языку.
-   Поддержка массивов сообщений.
-   Гибкая система языков (страны, ISO-коды).
-   Перезагрузка и обновление локалей без перезапуска приложения.

## Оглавление

-   [Пример структуры локалей](#пример-структуры-локалей)
-   [Быстрый старт](#быстрый-старт)
-   [Работа с сообщениями](#работа-с-сообщениями)
-   [Добавление новых языков](#добавление-новых-языков)
-   [Зависимости](#зависимости)
-   [Лицензия](#лицензия)

## Пример структуры локалей

```json
{
	"TEST_1": {
		"ru": "Опа... сообщение"
	},
	"TEST_2": {
		"ru": "Опа... сообщение",
		"en": "Opa... message"
	},
	"TEST_ARRAY_1": {
		"ru": ["Опа... сообщение1", "Опа... сообщение2"]
	}
}
```

## Быстрый старт

### Загрузка локалей из файла

```java
AbstractLocaleLoader loader = new FileLocaleLoader("src/main/resources/TestLocale.json");
LocalizationManager manager = new LocalizationManager(DefaultLanguages.RUSSIA);
manager.loadLocale(loader);
```

### Загрузка локалей по URL

```java
AbstractLocaleLoader loader = new WebLocaleLoader("https://example.com/locales.json");
LocalizationManager manager = new LocalizationManager(DefaultLanguages.RUSSIA);
manager.loadLocale(loader);
```

## Работа с сообщениями

### Получение строки

```java
String message = manager.getMessage(DefaultLanguages.RUSSIA, "TEST_1");
// "Опа... сообщение"
```

### Получение массива сообщений

```java
List<String> messages = manager.getMessageList(DefaultLanguages.RUSSIA, "TEST_ARRAY_1");
// ["Опа... сообщение1", "Опа... сообщение2"]
```

### Проверка наличия ключа

```java
boolean exists = manager.hasKey("TEST_2");
```

### Перезагрузка локалей

```java
manager.reloadLocales();
```

## Добавление новых языков

Для добавления нового языка реализуйте интерфейс `AbstractLanguage` или добавьте запись в `DefaultLanguages`:

```java
public enum NewLanguages implements AbstractLanguage {
    // ...существующие языки...
    CUSTOM("Custom", "000", "XX");
}
```

## Зависимости

```xml
<dependency>
    <groupId>ru.nesthcher</groupId>
    <artifactId>utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Лицензия

Эта библиотека доступна по [MIT лицензии](https://opensource.org/license/mit). Можете использовать её свободно.
