package tr.edu.sehir.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class client1 {

    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException{
        // write your code here
        System.out.println("welcome client");
        Socket socket = new Socket("localhost", 4444);
        System.out.println("Client connected");
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Ok");
        Message1 message = new Message1(15, 20);
        os.writeObject(message);
        System.out.println("message sent to the server ...");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Message1 returnMessage = (Message1) is.readObject();
        System.out.println("return Message is=" + returnMessage.getResult());
        socket.close();
    }
}
