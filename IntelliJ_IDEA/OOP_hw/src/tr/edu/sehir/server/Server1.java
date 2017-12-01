package tr.edu.sehir.server;

import tr.edu.sehir.Order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
        public static final int port = 4444;
        private ServerSocket ss = null;

        public void runServer() throws IOException, ClassNotFoundException {
            Cook ck1 = new Cook("Cook1");
            ss = new ServerSocket(port);
            System.out.println("Server is ready to accept connections");
            Socket socket = ss.accept();
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());


            Order order = (Order) is.readObject();
            ck1.cook(order);
            System.out.printf("Order of %s  prepared and ready to serve.\n", order.getMealName());

            os.writeObject(order);
            socket.close();
        }

}


