package ru.nesthcher.localization.utils;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.reflect.TypeToken;

import lombok.experimental.UtilityClass;
import ru.nesthcher.utils.json.JsonUtil;

/**
 * Утилитный класс для конвертации JSON в объекты и обратно.
 */
@UtilityClass
public class ConverterUtil {
    /**
     * Экземпляр Gson для сериализации и десериализации.
     */
    public final JsonUtil JSON_UTIL = new JsonUtil();
    /**
     * Тип для десериализации локалей.
     */
    public final Type TYPE = new TypeToken<ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>>() {}.getType();
}
