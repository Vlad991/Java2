package ua.univer.web.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.univer.controller.DAO.AccountDAO;
import ua.univer.controller.DAO.AdministratorDAO;
import ua.univer.controller.DAO.ClientDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("admin")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("fi");
		
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res = (HttpServletResponse) response;

		@SuppressWarnings("unused")
		final AccountDAO accountDAO = (AccountDAO) req.getServletContext().getAttribute("accountDAO");
//		@SuppressWarnings("unused")
		final ClientDAO clientDAO = (ClientDAO) req.getServletContext().getAttribute("clientDAO");
//		@SuppressWarnings("unused")
		final AdministratorDAO adminDAO = (AdministratorDAO) req.getServletContext().getAttribute("adminDAO");
		
		try {
			List<Integer> ids = clientDAO.getClientIds();
		for (Integer id : ids) {
			res.getWriter().append(clientDAO.getClientById(id).toString());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
