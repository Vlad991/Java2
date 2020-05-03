package ClientJabber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {
	// Выбираем порт вне пределов 1-1024:
	   public static final int PORT = 8080;
	   
	   public static void main(String[] args) throws IOException {
	      ServerSocket s = new ServerSocket(PORT);
	      System.out.println("Started: " + s);
	      try {
	         // Блокирует до тех пор, пока не возникнет соединение:
	         Socket socket = s.accept();
	         try {
	            System.out.println("Connection accepted: " + socket);
	            BufferedReader in = new BufferedReader(new InputStreamReader(
	                  socket.getInputStream()));
	            // Вывод автоматически выталкивается из буфера PrintWriter'ом
	            PrintWriter out = new PrintWriter(new BufferedWriter(
	                  new OutputStreamWriter(socket.getOutputStream())), true);
	            while (true) {
	               String str = in.readLine();
	               if (str.equals("END"))
	                  break;
	               System.out.println("Echoing: " + str);
	               out.println(str);
//	               try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
	            }
	            // Всегда закрываем два сокета...
	         }
	         finally {
	            System.out.println("closing...");
	            socket.close();
	         }
	      }
	      finally {
	         s.close();
	      }
	   }
}
