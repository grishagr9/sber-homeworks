# Многопоточная работа в Java – MultiThreading (2 часть)
1. Как получить ссылку на текущий поток ? с помощью метода Thread.currentThread();
2.  Зачем нужно ключевое слово synchronized ? На что его можно вещать(поле, метод, класс, конструктор..) ? Используем для синхронизации потоков, которые стучатся к одному ресурсу. Вешаем на поле, класс, метод, конструктор
3.  Захват какого монитора происходит при входе в synchronized метод/статик метод/блок ? При входе в synchronized метод, статический метод или блок захватывается монитор объекта, к которому этот метод принадлежит.
4.  Зачем нужно ключевое слово volatile ? На что его можно вещать(поле, метод, класс, конструктор..) ? Вешается на поле или переменную, гарантируя, что все изменения будут видны всем потокам
5.  Что делает метод Object#wait, Object#notify, Object#notifyAll ? Object#wait - используется для ожидания уведомления от другого потока
                   Object#notify - используется для уведомления потока, который ранее вызывал wait
                   Object#notifyAll - используется для уведомления всех потоков, которые ранее вызывали wait
6.  Что за исключение IllegalMonitorStateException ? Выбрасывается, когда несоответствующий поток пытается вызвать метод wait, notify или notifyAll на объекте, не являющемся монитором.
7.  Что делает метод Thread#join ? Вызывается из потока, и ждет завершения другого потока (блокируется, пока другой поток не закончит выполнение)
8.  Что делает метод Thread#interrupt ? Прерывает поток
## Task1 реализовать ThreadPool

public interface ThreadPool {
    void start(); // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)

    void execute(Runnable runnable); // складывает это задание в очередь. Освободившийся поток должен выполнить это задание. Каждое задание должны быть выполнено ровно 1 раз
}

## Task2 public class FixedThreadPool implements ThreadPool{

    private final int countThreads;
    private final Queue<Runnable> taskQueue;

    private final MyThread[] threads;

    public FixedThreadPool(int countThreads){
        this.countThreads = countThreads;
        this.taskQueue = new LinkedList<>();
        threads = new MyThread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
    }

    @Override
    public void start() {
        synchronized (taskQueue){
            taskQueue.notifyAll();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (taskQueue){
            taskQueue.add(runnable);
            taskQueue.notify();
        }
    }

}

## Результат 
Удалось реализовать интерфейс ThreadPool, а также два класса - с фиксированным количеством потоков и класс,  в котором количество потоков может меняться от минимального к максимальному. 
в классе Main проверил работоспособность обоих классов на примере. 
1. Создаем пул потоков, и запускаем 3 задачи, каждая задача выводит информацию о выполнении в консоль
2. Проверил работоспособность второй реализации интерфейса ThreadPool - созданные задачи добавляются в очередь, далее выполняются. После выполнения пулы останавливаются, прерывают свои потоки.
 
