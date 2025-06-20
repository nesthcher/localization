package ru.nesthcher.localization.implementation.loader;

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
import ru.nesthcher.localization.api.ConverterUtil;
import ru.nesthcher.localization.api.loader.AbstractLocaleLoader;
import ru.nesthcher.utils.JsonUtil;
import ru.nesthcher.utils.PatternUtil;

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
            @NotNull final String path
    ) {
        if (!path.endsWith(".json")) throw new IllegalArgumentException("Путь должен заканчиваться на .json");
        if(!PatternUtil.isUrl(path)) throw new IllegalArgumentException("Путь должен быть корректным URL");
        this.path = path;
    }

    /**
     * Загружает локали из веб-ресурса по указанному URL.
     * @return карта локалей (ключ - идентификатор сообщения, значение - карта языков и сообщений)
     *         или null, если ресурс недоступен или содержит невалидный JSON
     */
    @Override
    @Nullable
    public ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> getLocales() {
        try (final HttpClient client = HttpClient.newHttpClient()) {
            final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.path)).build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (!JsonUtil.isJsonValid(response.body())) return null;
            return ConverterUtil.GSON.fromJson(new StringReader(response.body()), ConverterUtil.TYPE);
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
