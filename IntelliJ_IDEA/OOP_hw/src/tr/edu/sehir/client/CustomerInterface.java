package tr.edu.sehir.client;

public interface CustomerInterface {
    public String getName();
    public float getMoney();
    public void setMoney(float Money);
    public void giveMoney(float Money, Waiter w);
    public void takeMoney(float Money, Waiter w);
    public void giveOrder(String orderMealName, Waiter w);
}
