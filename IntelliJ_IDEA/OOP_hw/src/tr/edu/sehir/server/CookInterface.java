package tr.edu.sehir.server;

import tr.edu.sehir.Order;

public interface CookInterface {
    public String getName();
    public void cook(Order order);
}
