package ua.univer.web;

import static java.util.Objects.nonNull;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.univer.controller.DAO.AccountDAO;
import ua.univer.controller.DAO.AdministratorDAO;
import ua.univer.controller.DAO.ClientDAO;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {

	private static String index = "/WEB-INF/view/login.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res = (HttpServletResponse) response;

		final String login = req.getParameter("login");
		final String password = req.getParameter("password");

		@SuppressWarnings("unused")
		final AccountDAO accountDAO = (AccountDAO) req.getServletContext().getAttribute("accountDAO");
//		@SuppressWarnings("unused")
		final ClientDAO clientDAO = (ClientDAO) req.getServletContext().getAttribute("clientDAO");
//		@SuppressWarnings("unused")
		final AdministratorDAO adminDAO = (AdministratorDAO) req.getServletContext().getAttribute("adminDAO");

		try {
			if (clientDAO.clientIsExist(login, password)) {

				final String role = "client";

				req.getSession().setAttribute("password", password);
				req.getSession().setAttribute("login", login);
				req.getSession().setAttribute("role", role);

				moveToMenu(req, res, role);

			} else if (adminDAO.adminIsExist(login, password)) {

				final String role = "admin";

				req.getSession().setAttribute("password", password);
				req.getSession().setAttribute("login", login);
				req.getSession().setAttribute("role", role);

				moveToMenu(req, res, role);

			} else {

				moveToMenu(req, res, "unknown");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final String role)
			throws ServletException, IOException {

		if (role.equals("admin")) {
			req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);

		} else if (role.equals("client")) {

			req.getRequestDispatcher("/WEB-INF/view/client_menu.jsp").forward(req, res);

		} else {

			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
