package ru.nesthcher.localization.implementations.loader;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ConcurrentHashMap;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.Getter;
import ru.nesthcher.localization.utils.ConverterUtil;
import ru.nesthcher.localization.interfaces.AbstractLocaleLoader;
import ru.nesthcher.utils.pattern.PatternUtil;

/**
 * Загрузчик локалей из веб-ресурса (по URL).
 * Позволяет получать локализованные сообщения из удалённого JSON-файла по HTTP(S).
 */
@Getter
public final class WebLocaleLoader implements AbstractLocaleLoader {
    private final String path;

    /**
     * Конструктор загрузчика локалей из веб-ресурса.
     * @param path URL к JSON-файлу локалей
     * @throws IllegalArgumentException если путь не оканчивается на .json или не является корректным URL
     */
    public WebLocaleLoader(
            @NotNull String path
    ) {
        if (!path.endsWith(".json")) throw new IllegalArgumentException("Путь должен заканчиваться на .json");
        if(!PatternUtil.isUrl(path)) throw new IllegalArgumentException("Путь должен быть корректным URL");
        this.path = path;
    }

    /**
     * Загружает локали из веб-ресурса по-указанному URL.
     * @return карта локалей (ключ - идентификатор сообщения, значение - карта языков и сообщений)
     *         или null, если ресурс недоступен или содержит невалидный JSON
     */
    @Override
    public @Nullable ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> getLocales() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.path)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (!ConverterUtil.JSON_UTIL.isJsonValid(response.body())) return null;
            return ConverterUtil.JSON_UTIL.gson.fromJson(new StringReader(response.body()), ConverterUtil.TYPE);
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
