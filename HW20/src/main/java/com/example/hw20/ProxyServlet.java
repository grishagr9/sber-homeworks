package com.example.hw20;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;

@WebServlet("/proxy")
public class ProxyServlet extends HttpServlet {
    private Map<String, CachedResponse> cache = new WeakHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlParam = request.getParameter("url");
        System.out.println(urlParam);
        if (urlParam == null || urlParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (cache.containsKey(urlParam)) {
            CachedResponse cachedResponse = cache.get(urlParam);
            response.setStatus(cachedResponse.getResponseCode());
            response.setHeader("Cached-Date", cachedResponse.getCachedDate().toString());
            response.getWriter().write(cachedResponse.getResponseContent());
        } else {
            URL url = new URL(urlParam);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                InputStream inputStream = connection.getInputStream();
                StringBuilder content = new StringBuilder();
                int data;
                while ((data = inputStream.read()) != -1) {
                    content.append((char) data);
                }
                inputStream.close();

                CachedResponse newCachedResponse = new CachedResponse(responseCode, new Date(), content.toString());
                cache.put(urlParam, newCachedResponse);

                response.setStatus(responseCode);
                response.setHeader("Cached-Date", newCachedResponse.getCachedDate().toString());
                response.getWriter().write(newCachedResponse.getResponseContent());
            } else {
                response.setStatus(responseCode);
            }
        }
    }

    @Getter
    private static class CachedResponse {
        private final int responseCode;
        private final Date cachedDate;
        private final String responseContent;

        public CachedResponse(int responseCode, Date cachedDate, String responseContent) {
            this.responseCode = responseCode;
            this.cachedDate = cachedDate;
            this.responseContent = responseContent;
        }

    }
}