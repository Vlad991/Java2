package ua.univer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/MyServlet", description = "Моё описание сервлета")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("firstName");
		String surname = request.getParameter("secondName");
		
		System.out.println(name);
		System.out.println(surname);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>Привет от MyServlet.GET " + name+ " " + surname + "</h3><br>Again</body></html>");
		out.close();
	}

}
