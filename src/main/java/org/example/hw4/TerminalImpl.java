package org.example.hw4;

import java.util.Scanner;

public class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator pinValidator;

    private static String info = "Выберите действие:\n" +
            "1. Проверить состояние счета\n" +
            "2. Положить деньги\n" +
            "3. Снять деньги\n" +
            "4. Выход";

    public TerminalImpl() {
        this.server = new TerminalServer();
        this.pinValidator = new PinValidator();
    }

    public void StartWork(){
        Scanner scanner = new Scanner(System.in);
        int countErrors = 0;
        System.out.println("для доступа к счету введите пин-кода (4 цифры)");


        System.out.println(info);
        while (true){
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    check();
                    continue;
                case 2:
                    continue;
                case 3:
                    continue;
                case 4:
                    return;
            }
        }
    }
    @Override
    public void check() {

    }

    @Override
    public void getMoney(int a) {
        if(a % 100 != 0){
            return;
        }

    }

    @Override
    public void giveMoney(int a) {
        if(a % 100 != 0){
            return;
        }
    }
}
