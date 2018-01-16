package sockets.server;

import sockets.common.Order;

public class Cook implements CookInterface {

    public Cook(String Name) { this.name = Name; }

    private String name;

    @Override
    public String getName() { return this.name; }

    @Override
    public void cook(Order order) {
        System.out.printf("Order of meal %s took and prepared by cook %s\n", order.getMealName(), this.name);
        order.setOrderResult("Meal " + order.getMealName() + " is ready to serve");
        System.out.printf(order.getOrderResult());
    }
}
