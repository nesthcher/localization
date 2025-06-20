package ru.nesthcher.localization.api;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.experimental.UtilityClass;

/**
 * Утилитный класс для конвертации JSON в объекты и обратно.
 */
@UtilityClass
public class ConverterUtil {
    /**
     * Экземпляр Gson для сериализации и десериализации.
     */
    public final Gson GSON = new Gson();
    /**
     * Тип для десериализации локалей.
     */
    public final Type TYPE = new TypeToken<ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>>() {
    }.getType();
}
