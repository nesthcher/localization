package ru.nesthcher.localization.api.loader;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Интерфейс загрузчика локалей.
 */
public interface AbstractLocaleLoader {
    /**
     * Получить путь к файлу или ресурсу локали.
     * @return путь
     */
    String getPath();

    /**
     * Получить локали в виде карты.
     * @return карта локалей
     */
    ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> getLocales();
}
