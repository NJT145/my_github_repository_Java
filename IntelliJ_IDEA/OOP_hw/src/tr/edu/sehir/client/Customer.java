package tr.edu.sehir.client;

import tr.edu.sehir.Order;

public class Customer implements CustomerInterface {

    public Customer(String Name) { this.name = Name; }

    private String name;
    private float money;

    @Override
    public String getName() { return name; }
    @Override
    public float getMoney() { return money; }
    @Override
    public void setMoney(float Money) { this.money = Money; }
    @Override
    public void giveMoney(float Money, Waiter w) {
        this.money = this.money - Money;
        System.out.printf("Customer gives cost equals to %s to waiter %s.\n", Money, w.getName());
        w.takeMoney(Money, this);
    }
    @Override
    public void takeMoney(float Money, Waiter w) {    }
    @Override
    public void giveOrder(String orderMealName, Waiter w) {
        System.out.printf("%s was requested by %s to %s\n", orderMealName, this.getName(), w.getName());
        w.takeOrder(orderMealName, this);
    }

}
