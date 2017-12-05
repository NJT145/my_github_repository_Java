package tr.edu.sehir.client;

public interface CustomerWaiterInterface {
    public String getName();
    public float getMoney();
    public void setMoney(float Money);
    public void giveMoney(float Money, Customer c, Waiter w);
    public void takeMoney(float Money, Customer c, Waiter w);
    public void giveOrder(String orderMealName, Customer c, Waiter w);
    public void takeOrder(String orderMealName, Customer c, Waiter w);
}
