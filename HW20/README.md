# Домашнее задание №20
## Задание 1 
   Написать WEB-приложение c сервлетом|сервлетным фильтром, который осуществляет получение содержимого удалённого ресурса и возвращает его в своём ответе (GET запрос).
   Ссылка на ресурс передаётся в параметре url исходного запроса.
   Сервлет должен кэшировать результаты успешных запросов (код ответа 2??), и в случае повторного запроса возвращать сохранённый результат.
   В ответе должен быть дополнительный заголовок с информацией о дате занесения его в кэш (дате фактического получения ответа с удалённого сервера).
   Используйте WeakHashMap в качестве структуры кэша, где URL ключ, а значение - код ответа + заголовки + содержимое.

## Задание 2

Реализуйте REST сервис работы с терминальным сервером из домашнего задания занятия про Exceptions. Используйте Spring Web MVC. Верно выбирайте типы запросов и коды состояний HTTP.

## Решение
### Задание 1
Создан класс proxyServlet, который наследуется от HttpServlet, переопределяет метод doGet.
Сервлет получает удаленный ресурс, переданный по ссылке. Также добавлена возможность кэширования ответов при повторных запросах.

Пример запроса:
GET /ProxyServlet?url=<ссылка на ресурс>

### Задание 2