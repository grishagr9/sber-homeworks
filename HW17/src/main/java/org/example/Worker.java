package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class Worker {

    private final DownLoader downLoader;
    private final int MAX_CONCURRENT_DOWNLOADS = 3;

    /**
     *
     * @param inputPath Файл, откуда брать ссылки для скачивания файлов
     * @param outputPath Директория, куда скачать файлы
     * @throws IOException
     * @throws InterruptedException
     */
    public void run(String inputPath, String outputPath) throws IOException, InterruptedException {
        downLoader.setMAX_DOWNLOAD_SPEED(500); //устанавливаем скорость скачивания
        BufferedReader reader = null; // Получить список ссылок из текстового файла
        try {
            reader = new BufferedReader(new FileReader(inputPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> links = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            links.add(line);
        }
        reader.close();

        // Создать папку для скачивания файлов
        Path downloadPath = Paths.get(outputPath);
        Files.createDirectories(downloadPath);

        // Создать пул потоков для скачивания файлов
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONCURRENT_DOWNLOADS);

        // Скачать файлы в параллельных потоках
        for (String link : links) {
            executorService.submit(() -> downLoader.downloadFile(link, downloadPath));
        }

        // Завершить работу пула потоков и дождаться завершения всех задач
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
