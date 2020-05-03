package ua.univer;

public class Main {

	public static void main(String[] args) throws Exception {
//		ProductServer server = new ProductServer();
//		server.start(8080);
		ProductInfoClient pic = new ProductInfoClient();
		pic.productClient.disconnect();
	}

}
