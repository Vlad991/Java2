package ua.univer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProductServer {
    private ServerSocket server = null;
    private Socket sock = null;
    private ObjectInputStream in1 = null;
    private ObjectOutputStream out = null;
    ProductDAO products = new ProductDAO();

    public void start(int port) throws Exception {
        server = new ServerSocket(port);
        while (true) {
            sock = server.accept();

            System.out.println("Client accepted!");
            out = new ObjectOutputStream(sock.getOutputStream());
            in1 = new ObjectInputStream(sock.getInputStream());

            while (processQuery()) ;

        }
//		in1.close();
//		out.close();

    }

    private boolean processQuery() throws Exception {
        try {
            String request = (String) in1.readObject();
            Object object = in1.readObject();// после этой операции закрывается

            switch (request) {
                case "add":
                    products.addProduct((Product) object);
                    out.writeObject(new Product());
                    out.writeObject("product added");
                    out.flush();
                    return true;
                case "set":
                    products.setProduct((Product) object);
                    out.writeObject(new Product());
                    out.writeObject("product setted");
                    out.flush();
                    return true;
                case "remove":
                    products.removeProduct((int) object);
                    out.writeObject(new Product());
                    out.writeObject("product removed");
                    out.flush();
                    return true;
                case "getById":
                    out.writeObject(products.getProductById((int) object).get(0));
                    out.writeObject("product finded");
                    out.flush();
                    return true;
                case "getIds":
                    out.writeObject((ArrayList<Integer>) products.getProductIds());
                    out.writeObject("ids finded");
                    out.flush();
                    return true;

                default:
                    out.writeObject("operation failed");
                    out.flush();
                    out.flush();
                    break;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        ProductServer server = new ProductServer();
        server.start(8080);
    }

}
