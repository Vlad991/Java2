package ua.univer;

public class TestProductClientServerApp {

	public static void main(String[] args) throws Exception {
		ProductServer server = new ProductServer();
		server.start(8080);
		new ProductInfoClient();
	}

}
