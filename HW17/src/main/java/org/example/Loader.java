package org.example;

import java.nio.file.Path;

public interface Loader {
    /**
     * Метод должен загружать файлы из источника и отправлять их в указанную директорию
     * @param link Файл, откуда брать ссылки для скачивания файлов
     * @param downloadPath Директория, куда скачать файлы
     */
    void downloadFile(String link, Path downloadPath);
}
