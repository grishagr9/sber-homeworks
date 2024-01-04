package org.example.hw4;

import javax.security.auth.login.AccountLockedException;
import java.util.Scanner;

public class PinValidator {
    private final String pinCode = "1234";
    private int countErrors;
    private long time;
    public PinValidator(){
        time = 0;
        countErrors = 0;
    }

    private boolean isBlocked() throws AccountLockedException {
        if(time > 0){
            if(time - System.currentTimeMillis() > 0){
                throw new AccountLockedException("Терминал заблокирован");
            }
        }
        return false;
    }

    public boolean inputPassword() throws AccountLockedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пин-код по-символьно");
        int countDigit = 0;
        StringBuilder pin = new StringBuilder();
        while(true){
            if(countDigit==4){
                countDigit = 0;
                if(pin.toString().equals(pinCode)){
                    countErrors = 0;
                    time = 0;
                    return true;
                }
                else {
                    pin = new StringBuilder();
                    countErrors++;
                    System.err.println(String.format("Неверно введен пин-код, попыток осталось %d",3 - countErrors));
                    if(countErrors == 3){
                        System.out.println("Блокировка на 10 секунд");
                        countErrors = 0;
                        time = System.currentTimeMillis() + 10000;
                    }
                }
            }
            String current = scanner.next();
            if(!isBlocked()){
                if(!Character.isDigit(current.charAt(0))){
                    System.err.println("Вводите цифровые символы");
                }else {
                    pin.append(current);
                    countDigit++;
                }
            }
        }
    }

}
