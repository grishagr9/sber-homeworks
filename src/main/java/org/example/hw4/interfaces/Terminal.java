package org.example.hw4.interfaces;

import org.example.hw4.exceptions.IncorrectSumException;
import org.example.hw4.exceptions.NotEnoughMoneyException;

import javax.security.auth.login.AccountLockedException;

public interface Terminal {

    public void StartWork() throws AccountLockedException;
    void check();
    void getMoney(int sum) throws NotEnoughMoneyException, IncorrectSumException;
    void putMoney(int sum) throws IncorrectSumException;
}
