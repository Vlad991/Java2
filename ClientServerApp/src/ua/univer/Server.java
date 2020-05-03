package ua.univer;
import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException {
		int count = 0;
		ServerSocket serverSocket = new ServerSocket(8080);
		
		while (true) {
		Socket clientSocket = serverSocket.accept();
		
		System.out.println("Client accepted " + (++count));
		OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String request = reader.readLine();
		String response = "#" + count + ", your message length is " + request.length() + "\n";
		writer.write(response);
		writer.flush();
		writer.close();
		
		reader.close();
		writer.close();
		clientSocket.close();
		}
		
		//serverSocket.close();
		
	}

}
