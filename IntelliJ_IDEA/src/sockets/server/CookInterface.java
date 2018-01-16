package sockets.server;

import sockets.common.Order;

public interface CookInterface {
    public String getName();
    public void cook(Order order);
}
