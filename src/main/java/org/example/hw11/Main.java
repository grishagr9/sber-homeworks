package org.example.hw11;

public class Main {
    static void questionTask(){
        System.out.println("""
                1. Как получить ссылку на текущий поток ?
                2. Зачем нужно ключевое слово synchronized ? На что его можно вещать(поле, метод, класс, конструктор..) ?
                3. Захват какого монитора происходит при входе в synchronized метод/статик метод/блок ?
                4. Зачем нужно ключевое слово volatile ? На что его можно вещать(поле, метод, класс, конструктор..) ?
                5. Что делает метод Object#wait, Object#notify, Object#notifyAll
                6. Что за исключение IllegalMonitorStateException ?
                7. Что делает метод Thread#join ?
                8. Что делает метод Thread#interrupt ?
                """);

        System.err.println("""
                1. с помощью метода Thread.currentThread();
                2. Используем для синхронизации потоков, которые стучатся к одному ресурсу. Вешаем на поле, класс, метод, конструктор
                3. При входе в synchronized метод, статический метод или блок захватывается монитор объекта, к которому этот метод принадлежит.
                4. Вешается на поле или переменную, гарантируя, что все изменения будут видны всем потокам
                5. Object#wait - используется для ожидания уведомления от другого потока
                   Object#notify - используется для уведомления потока, который ранее вызывал wait
                   Object#notifyAll - используется для уведомления всех потоков, которые ранее вызывали wait
                6. Выбрасывается, когда несоответствующий поток пытается вызвать метод wait, notify или notifyAll на объекте, не являющемся монитором.
                7. Вызывается из потока, и ждет завершения другого потока (блокируется, пока другой поток не закончит выполнение)
                8. Прерывает поток
                """);
    }
    public static void main(String[] args) {
        //questionTask();

        ThreadPool threadPool = new FixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }
        threadPool.start();
    }
}
