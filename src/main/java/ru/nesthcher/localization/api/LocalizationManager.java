package ru.nesthcher.localization.api;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.jetbrains.annotations.NotNull;

import ru.nesthcher.localization.api.language.AbstractLanguage;
import ru.nesthcher.localization.api.loader.AbstractLocaleLoader;
import ru.nesthcher.utils.ArrayUtil;
import ru.nesthcher.utils.logger.AbstractLoggerApi;

/**
 * Менеджер локализации для загрузки и получения сообщений на разных языках.
 */
public class LocalizationManager {
    /**
     * Объект для логирования
     */
    private final AbstractLoggerApi loggerApi;
    /**
     * Язык по умолчанию.
     */
    private final AbstractLanguage defaultLanguage;
    /**
     * Загруженные загрузчики локалей.
     */
    private final ConcurrentHashMap<String, AbstractLocaleLoader> loadedLocales;
    /**
     * Сообщения локализации.
     */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> messages;

    /**
     * Конструктор менеджера локализации.
     * @param defaultLanguage язык по умолчанию
     */
    public LocalizationManager(
            @NotNull AbstractLoggerApi loggerApi,
            @NotNull AbstractLanguage defaultLanguage
    ) {
        this.loggerApi = loggerApi;
        this.defaultLanguage = defaultLanguage;
        this.loadedLocales = new ConcurrentHashMap<>();
        this.messages = new ConcurrentHashMap<>();
    }

    /**
     * Перезагружает все локали.
     */
    public void reloadLocales() {
        this.messages.clear();
        for (AbstractLocaleLoader localeLoader : this.loadedLocales.values())
            loadLocale(localeLoader);
    }

    /**
     * Загружает локаль с помощью переданного загрузчика.
     * @param localeLoader загрузчик локали
     */
    public void loadLocale(@NotNull AbstractLocaleLoader localeLoader) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> loadLocales = localeLoader.getLocales();
        if (loadLocales == null || loadLocales.isEmpty()) {
            this.loadedLocales.remove(localeLoader.getPath());
        } else {
            ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> locales = new ConcurrentHashMap<>();
            for (Map.Entry<String, ConcurrentHashMap<String, Object>> entry : loadLocales.entrySet()) {
                if (entry.getValue() == null || entry.getValue().isEmpty()) continue;
                locales.put(entry.getKey(), entry.getValue());
            }
            this.messages.putAll(locales);
            if (!this.loadedLocales.containsKey(localeLoader.getPath()))
                this.loadedLocales.put(localeLoader.getPath(), localeLoader);
            loggerApi.log(LocalizationManager.class, "Локаль " + localeLoader.getPath() + " успешно загружена");
        }
    }

    /**
     * Получает объект сообщения по ключу и языку.
     * @param type язык
     * @param key ключ сообщения
     * @return объект сообщения или null
     */
    private Object getObjectMessage(
            @NotNull AbstractLanguage type,
            @NotNull String key
    ) {
        ConcurrentHashMap<String, Object> data = this.messages.getOrDefault(key, null);
        if (data == null) return null;
        Object selectedMessage = data.getOrDefault(
                type.getIsoCode(),
                isDefaultLanguageType(type)
                        ? null
                        : data.getOrDefault(this.defaultLanguage.getIsoCode(), null)
        );
        if (selectedMessage == null
                || selectedMessage instanceof ArrayList<?> && ((ArrayList<?>) selectedMessage).isEmpty()
        ) return null;
        return selectedMessage;
    }

    /**
     * Получает строковое сообщение по ключу и языку.
     * @param type язык
     * @param key ключ сообщения
     * @return строка сообщения или ключ, если не найдено
     */
    public String getMessage(
            @NotNull AbstractLanguage type,
            @NotNull String key
    ) {
        Object selectedMessage = getObjectMessage(type, key);
        if (!(selectedMessage instanceof String)) return key;
        return String.valueOf(selectedMessage);
    }

    /**
     * Получает список сообщений по ключу и языку.
     * @param type язык
     * @param key ключ сообщения
     * @return список сообщений или список с ключом, если не найдено
     */
    public ArrayList<String> getMessageList(
            @NotNull AbstractLanguage type,
            String key
    ) {
        Object selectedMessage = getObjectMessage(type, key);
        if (!(selectedMessage instanceof ArrayList<?>)) return new ArrayList<>(List.of(key));
        ArrayList<String> selectedMessageArray = ArrayUtil.convertObjectToList(selectedMessage, String.class);
        if (selectedMessageArray == null) return new ArrayList<>(List.of(key));
        return selectedMessageArray;
    }

    /**
     * Проверяет наличие ключа сообщения.
     * @param messageKey ключ сообщения
     * @return true, если ключ существует
     */
    public boolean hasKey(
            @NotNull String messageKey
    ) {
        return this.messages.containsKey(messageKey);
    }

    /**
     * Проверяет, является ли язык языком по умолчанию.
     * @param language язык
     * @return true, если язык совпадает с языком по умолчанию
     */
    public boolean isDefaultLanguageType(
            @NotNull AbstractLanguage language
    ) {
        return Objects.equals(language.getIsoCode(), this.defaultLanguage.getIsoCode());
    }
}
