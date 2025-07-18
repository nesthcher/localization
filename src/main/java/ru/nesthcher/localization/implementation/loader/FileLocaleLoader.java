package ru.nesthcher.localization.implementation.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.Getter;
import ru.nesthcher.localization.api.ConverterUtil;
import ru.nesthcher.localization.api.loader.AbstractLocaleLoader;
import ru.nesthcher.utils.JsonUtil;

/**
 * Загрузчик локалей из локального JSON-файла.
 * Позволяет получать локализованные сообщения из указанного файла.
 */
@Getter
public final class FileLocaleLoader implements AbstractLocaleLoader {
    private final String path;

    /**
     * Конструктор загрузчика локалей из файла.
     * @param path путь к JSON-файлу локалей
     * @throws IllegalArgumentException если путь не оканчивается на .json
     */
    public FileLocaleLoader(
            @NotNull String path
    ) {
        if (!path.endsWith(".json")) throw new IllegalArgumentException("Путь должен заканчиваться на .json");
        this.path = path;
    }

    /**
     * Загружает локали из указанного файла.
     * @return карта локалей (ключ - идентификатор сообщения, значение - карта языков и сообщений)
     *         или null, если файл не найден или содержит невалидный JSON
     */
    @Override
    @Nullable
    public ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> getLocales() {
        try {
            String strJson = Files.readString(Path.of(this.path));
            if (!JsonUtil.isJsonValid(strJson)) return null;
            return ConverterUtil.GSON.fromJson(strJson, ConverterUtil.TYPE);
        } catch (IOException e) {
            return null;
        }
    }
}
