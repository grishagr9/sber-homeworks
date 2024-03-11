package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Setter
@Getter
public class DownLoader {

    private int MAX_DOWNLOAD_SPEED; // КБ/с

    public void downloadFile(String link, Path downloadPath) {
        try {
            URL url = new URL(link);
            String fileName = Paths.get(url.getPath()).getFileName().toString();
            Path filePath = downloadPath.resolve(fileName);

            // Ограничить скорость загрузки
            long startTime = System.currentTimeMillis();
            long totalBytesDownloaded = 0;
            byte[] buffer = new byte[1024];
            try (java.io.InputStream inputStream = url.openStream();
                 java.io.OutputStream outputStream = Files.newOutputStream(filePath)) {
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    totalBytesDownloaded += bytesRead;

                    // Проверить скорость загрузки
                    long currentTime = System.currentTimeMillis();
                    long elapsedTime = currentTime - startTime;
                    long downloadSpeed = (totalBytesDownloaded * 1000) / elapsedTime;
                    if (downloadSpeed > MAX_DOWNLOAD_SPEED * 1024) {
                        Thread.sleep(100);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Файл " + fileName + " скачан");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
