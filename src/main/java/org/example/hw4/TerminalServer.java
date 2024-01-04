package org.example.hw4;

public class TerminalServer {
    private int money;

    public TerminalServer(){
        money = 0;
    }

    /*
    * положить деньги на счет
    * */
    public Boolean putMoney(int sum) throws IllegalArgumentException{
        if(sum <= 0){
            throw new IllegalArgumentException("Сумма пополнения не может быть меньше нуля");
        }
        this.money += sum;

        return true;
    }

    /*
    * снять деньги со счета
    * */
    public Boolean getMoney(int sum) throws IllegalArgumentException, NotEnoughMoneyException {
        if(sum <= 0){
            throw new IllegalArgumentException("Сумма снятия не может быть меньше нуля");
        }
        int updateMoney = this.money - sum;
        if(updateMoney < 0){
            throw new NotEnoughMoneyException("Недостаточно средств для выполнения операции");
        }
        this.money = updateMoney;
        return true;
    }

    /*
    * проверка состояния счета
    * */
    public Integer getAccStatus(){
        return money;
    }

}
