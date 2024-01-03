package org.example.hw4;

public class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl() {
        this.server = new TerminalServer();
        this.pinValidator = new PinValidator();
    }

    @Override
    public void check() {

    }

    @Override
    public void getMoney(int a) {

    }

    @Override
    public void giveMoney(int a) {

    }
}
