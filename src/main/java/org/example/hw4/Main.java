package org.example.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static boolean readContent(String url) throws IOException, MalformedURLException {
        URL website = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(website.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        return true;
    }
    static void task1(){
        TerminalImpl terminal = new TerminalImpl();
        terminal.StartWork();
    }
    static void task2(){
        System.out.println("Введите url адрес страницы ");
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        while (!result){
            try {
                String url = scanner.nextLine();
                result = readContent(url);
            }catch (IOException ioException){
                System.err.println(ioException.getMessage());
                System.out.print("Введите url адрес страницы еще раз");
            }
        }
    }
    static void task3(){
        System.out.println("1.\tПравильно ли написан следующий код:\n" +
                "\ttry {\n" +
                "    \n" +
                "\t} finally {\n" +
                "    \n" +
                "\t}\n");
        System.err.println("1. Нет, пропущена секция catch. Код откомпилируется, но исключения отлавливать он не способен");

        System.out.println("2. Какие исключения могут быть перехвачены следующим обработчиком:\n" +
                "\tcatch (Exception e) {\n" +
                "     \n" +
                "\t}\n" +
                "Что не так с использованием такого обработчика?\n");
        System.err.println("2. Обработчик перехватит все исключения класса Exception и его наследников. " +
                "\nМинус такого обработчика - мы не узнаем кого именно из наследников он перехватил -> не узнаем где именно ошибка");

        System.out.println("3. Имеется ли ошибка в написании такого обработчика исключения? Скомпилируется ли этот код? \n" +
                "\ttry {\n" +
                "\n" +
                "\t} catch (Exception e) {\n" +
                "    \n" +
                "\t} catch (ArithmeticException a) {\n" +
                "    \n" +
                "\t}\n");
        System.err.println("3. Код не скомпилируется, потому что все исключения класса ArithmeticException уже перехвачены классом-родителем Exception.\n" +
                "Если поменять местами блоки catch - все заработает");

        System.out.println("4. Сопоставление");
        System.out.println("а) int[] A; A[0] = 0; - 1) ошибка;");
        System.out.println("б) JVM начинает запускать вашу программу, но обнаруживает, что не может найти классы Java платформы; - 3) ошибка компиляции;");
        System.out.println("в) программа читает входной поток и достигает маркера конца потока; - 4) исключение не произойдёт.");
        System.out.println("г) после достижения маркера конца входного потока, но до закрытия самого потока, программа пытаться считать данные. - 2) проверяемое исключение;");
    }
    public static void main(String[] args)  {
        //task1();
        //task2();
        //task3();
    }
}
