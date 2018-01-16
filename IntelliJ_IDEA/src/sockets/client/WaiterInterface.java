package sockets.client;

public interface WaiterInterface {
    public String getName();
    public float getMoney();
    public void setMoney(float Money);
    public void giveMoney(float Money, Customer c);
    public void takeMoney(float Money, Customer c);
    public void takeOrder(String orderMealName, Customer c);
}
