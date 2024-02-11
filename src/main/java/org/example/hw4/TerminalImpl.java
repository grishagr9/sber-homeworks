package org.example.hw4;

import org.example.hw4.exceptions.IncorrectSumException;
import org.example.hw4.exceptions.NotEnoughMoneyException;
import org.example.hw4.interfaces.Terminal;

import javax.security.auth.login.AccountLockedException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalImpl implements Terminal {
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

    public void StartWork() {
        Scanner scanner = new Scanner(System.in);
        int countErrors = 0;
        System.out.println("для доступа к счету введите пин-кода (4 цифры)");
        boolean isLocked = false;
        int command;
        while (true) {
            try {
                isLocked = pinValidator.inputPassword();
            } catch (AccountLockedException exception) {
                System.err.println("Терминал заблокирован");
            }
            if(isLocked){
                break;
            }
        }
        while (true){
            System.out.println(info);
            try {
                command = scanner.nextInt();
            }catch (InputMismatchException exception){
                System.err.println("Ввод некорректен. Введите цифру от 1 до 5");
                scanner = new Scanner(System.in);
                continue;
            }
            switch (command){
                case 1:
                    check();
                    continue;
                case 2:
                    try {
                        System.out.print("Введите сумму, кратную 100 ");
                        int sum = scanner.nextInt();
                        putMoney(sum);
                        System.out.println("Операция успешно выполнена");
                        continue;
                    }catch (InputMismatchException inputMismatchException){
                        System.err.println("Ввод некорректен. Введите цифру");
                        scanner = new Scanner(System.in);
                        continue;
                    }catch (IllegalArgumentException illegalArgumentException){
                        System.err.println("Ввод некорректен. Сумма должна быть больше нуля");
                        continue;
                    }catch (IncorrectSumException incorrectSumException){
                        System.err.println(incorrectSumException.getMessage());
                        continue;
                    }
                case 3:
                    try {
                        System.out.print("Введите сумму, кратную 100 ");
                        int sum2 = scanner.nextInt();
                        getMoney(sum2);
                        System.out.println("Операция успешно выполнена");
                        continue;
                    }catch (InputMismatchException inputMismatchException){
                        System.err.println("Ввод некорректен. Введите цифру");
                        scanner = new Scanner(System.in);
                        continue;
                    }catch (IllegalArgumentException illegalArgumentException){
                        System.err.println("Ввод некорректен. Сумма должна быть больше нуля");
                        continue;
                    }catch (NotEnoughMoneyException notEnoughMoneyException){
                        System.err.println("На счету недостаточно средств для выполнения операции");
                        continue;
                    }catch (IncorrectSumException incorrectSumException){
                        System.err.println(incorrectSumException.getMessage());
                        continue;
                    }
                case 4:
                    System.out.println("До свидания. Хорошего дня!");
                    return;
            }
        }
    }

    @Override
    public void check() {
        System.out.println(String.format("На счету %d",server.getAccStatus()));
    }

    @Override
    public void getMoney(int sum) throws NotEnoughMoneyException, IllegalArgumentException, IncorrectSumException {
        if(sum % 100 != 0){
            throw new IncorrectSumException("Введенная сумма не кратна 100");
        }
        server.getMoney(sum);
    }

    @Override
    public void putMoney(int sum) throws IllegalArgumentException, IncorrectSumException {
        if(sum % 100 != 0){
            throw new IncorrectSumException("Введенная сумма не кратна 100");
        }

        server.putMoney(sum);
    }
}
