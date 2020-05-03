package ua.univer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class ProductClient {
	private Socket sock = null;
//	private OutputStreamWriter out2 = null;
	private ObjectOutputStream out1 = null;
	private ObjectInputStream in = null;
	private ResultQuery result;

	public ProductClient(String ip, int port) throws IOException {
		sock = new Socket(ip, port);
		
		out1 = new ObjectOutputStream(sock.getOutputStream());
		in = new ObjectInputStream(sock.getInputStream());
	}
	
	private ResultQuery sendQuery(String operation, Object object) throws IOException {
		out1.writeObject(operation);
		
		out1.writeObject(object);
		out1.flush();
		
		Object resultObject = null;
		try {
			resultObject = in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultString = null;
		try {
			resultString = (String)in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResultQuery(resultObject, resultString);
	}
	
	public void addProduct(Product product) throws IOException {
		System.out.println(sendQuery("add", product).resultString);
	}
	
	public void setProduct(Product product) throws IOException {
		System.out.println(sendQuery("set", product).resultString);
	}
	
	public void removeProduct(int id) throws IOException {
		System.out.println(sendQuery("remove", id).resultString);
	}
	
	public Product getProductById(int id) throws IOException {
		ResultQuery result = sendQuery("getById", id);
		System.out.println(result.resultString);
		return (Product)result.resultObject;
	}
	
	public List<Integer> getProductIds() throws IOException {
		ResultQuery result = sendQuery("getIds", new Product());
		System.out.println(result.resultString);
		return (List<Integer>)result.resultObject;
	}
	
	public void disconnect() throws IOException {
		sock.close();
	}
	
	public static void main(String[] args) {
	}

}

class ResultQuery {
	public Object resultObject;
	public String resultString;
	
	public ResultQuery(Object resultObject, String resultString) {
		super();
		this.resultObject = resultObject;
		this.resultString = resultString;
	}
	
	
}
