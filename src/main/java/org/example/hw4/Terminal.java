package org.example.hw4;

import javax.security.auth.login.AccountLockedException;

public interface Terminal {

    public void StartWork() throws AccountLockedException;
    void check();
    void getMoney(int sum) throws NotEnoughMoneyException, IncorrectSumException;
    void putMoney(int sum) throws IncorrectSumException;
}
