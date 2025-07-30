package ru.nesthcher.localization.interfaces;

/**
 * Интерфейс языка для локализации.
 */
public interface AbstractLanguage {
    /**
     * Получить название языка/страны.
     * @return название
     */
    String getName();

    /**
     * Получить телефонный код страны.
     * @return телефонный код
     */
    String getCountryCode();

    /**
     * Получить ISO-код страны.
     * @return ISO-код
     */
    String getIsoCode();
}
