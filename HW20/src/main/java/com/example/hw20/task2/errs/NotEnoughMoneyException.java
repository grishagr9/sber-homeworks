package com.example.hw20.task2.errs;

public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException(String msg){
        super(msg);
    }
}
