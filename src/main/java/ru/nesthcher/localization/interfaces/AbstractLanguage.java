package ru.nesthcher.localization.interfaces;

import com.google.gson.annotations.SerializedName;

/**
 * Интерфейс языка для локализации.
 */
public interface AbstractLanguage {
    /**
     * Получить название языка/страны.
     * @return название
     */
    @SerializedName("name")
    String getName();

    /**
     * Получить телефонный код страны.
     * @return телефонный код
     */
    @SerializedName("countryCode")
    String getCountryCode();

    /**
     * Получить ISO-код страны.
     * @return ISO-код
     */
    @SerializedName("isoCode")
    String getIsoCode();
}
