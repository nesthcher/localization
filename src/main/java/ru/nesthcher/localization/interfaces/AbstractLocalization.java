package ru.nesthcher.localization.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Интерфейс локализации для загрузки и получения сообщений на разных языках.
 */
public interface AbstractLocalization {
    /**
     * Перезагружает все локали.
     */
    void reloadLocales();

    /**
     * Загружает локаль с помощью переданного загрузчика.
     * @param localeLoader загрузчик локали
     */
    void loadLocale(@NotNull AbstractLocaleLoader localeLoader);

    /**
     * Получает строковое сообщение по ключу и языку.
     * @param type язык
     * @param key ключ сообщения
     * @return строка сообщения или ключ, если не найдено
     */
    String getMessage(@NotNull AbstractLanguage type, @NotNull String key);

    /**
     * Получает список сообщений по ключу и языку.
     * @param type язык
     * @param key ключ сообщения
     * @return список сообщений или список с ключом, если не найдено
     */
    ArrayList<String> getMessageList(@NotNull AbstractLanguage type, String key);

    /**
     * Проверяет наличие ключа сообщения.
     * @param messageKey ключ сообщения
     * @return true, если ключ существует
     */
    boolean hasKey(@NotNull String messageKey);

    /**
     * Проверяет, является ли язык языком по умолчанию.
     * @param language язык
     * @return true, если язык совпадает с языком по умолчанию
     */
    boolean isDefaultLanguageType(@NotNull AbstractLanguage language);
}
