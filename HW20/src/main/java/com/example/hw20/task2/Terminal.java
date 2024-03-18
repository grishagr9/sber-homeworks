package com.example.hw20.task2;

import com.example.hw20.task2.errs.IncorrectSumException;
import com.example.hw20.task2.errs.NotEnoughMoneyException;

import javax.security.auth.login.AccountLockedException;

public interface Terminal {
    int check();
    void getMoney(int sum) throws NotEnoughMoneyException, IncorrectSumException;
    void putMoney(int sum) throws IncorrectSumException;
}