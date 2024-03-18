package com.example.hw20.task2;

import com.example.hw20.task2.errs.IncorrectSumException;
import com.example.hw20.task2.errs.NotEnoughMoneyException;

import javax.security.auth.login.AccountLockedException;

public class TerminalImpl implements Terminal{

    private int balance;

    public TerminalImpl(int balance){
        this.balance = balance;
    }

    @Override
    public int check() {
        return balance;
    }

    @Override
    public void getMoney(int sum) throws NotEnoughMoneyException, IncorrectSumException {
        if (sum > balance) {
            throw new NotEnoughMoneyException("Недостаточно средств на счету");
        }
        balance -= sum;
    }

    @Override
    public void putMoney(int sum) throws IncorrectSumException {
        balance += sum;
    }
}
