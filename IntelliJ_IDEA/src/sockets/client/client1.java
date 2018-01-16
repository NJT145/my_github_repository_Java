package sockets.client;

import sockets.common.Order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client1 {

    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException{
        Customer c1 = new Customer("Customer1");
        c1.setMoney(115);
        Waiter w1 = new Waiter("Waiter1");
        w1.setMoney(10);
        // write your code here
        System.out.println("welcome client");
        Socket socket = new Socket("localhost", 4444);
        System.out.println("Client connected");
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Ok");
        c1.giveOrder("salad", w1);
        Order order = w1.order;
        os.writeObject(order);
        System.out.println("message sent to the server ...");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Order returnMessage = (Order) is.readObject();
        System.out.println("return Message is=" + returnMessage.getOrderResult());
        socket.close();
    }
}
