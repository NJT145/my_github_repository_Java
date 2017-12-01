package tr.edu.sehir.client;

import tr.edu.sehir.Order;

public class Waiter implements WaiterInterface {

    public Waiter(String Name) { this.name = Name; }

    private String name;
    private float money;
    public Order order;

    @Override
    public String getName() { return this.name; }
    @Override
    public void setMoney(float Money) { this.money = Money; }
    @Override
    public float getMoney() { return money; }
    @Override
    public void giveMoney(float Money, Customer c) {    }
    @Override
    public void takeMoney(float Money, Customer c) {
        this.money = this.money + Money;
        System.out.printf("Waiter takes cost equals to %s from customer %s.\n", Money, c.getName());
    }
    @Override
    public void takeOrder(String orderMealName, Customer c) {
        boolean itemSelected = this.menuSelectItem(orderMealName);
        if(itemSelected) {
            System.out.printf("Meal cost is %s .", this.order.getMealCost());
        }
        else {
            return;
        }
    }
    public boolean menuSelectItem(String itemName){

        if (itemName.equalsIgnoreCase("salad")) {
            this.order = new Order("salad",1);
            return true;
        }
        else if (itemName.equalsIgnoreCase("main meal")) {
            this.order = new Order("main meal",2);
            return true;
        }
        else {
            System.out.println("meal not in menu...");
            return false;
        }
    }
}
