package sockets.tr.edu.sehir.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
        public static final int port = 4444;
        private ServerSocket ss = null;

        public void runServer() throws IOException, ClassNotFoundException {
            ss = new ServerSocket(port);
            System.out.println("Server is ready to accept connections");
            Socket socket = ss.accept();
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());


            Message1 m = (Message1) is.readObject();
            doSomething(m);

            os.writeObject(m);
            socket.close();
        }

        private void doSomething(Message1 m) {
            m.setResult(m.getA().intValue() , m.getB().intValue());
        }

}


