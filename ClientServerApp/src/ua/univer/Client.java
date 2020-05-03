package ua.univer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket clientSocket = new Socket("127.0.0.1", 8080);
		
		
		OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		writer.write("Get me some infotmation\n");
		writer.flush();
		
		String response = reader.readLine();
		System.out.println(response);
		
		writer.close();
		reader.close();
		clientSocket.close();
	}

}
