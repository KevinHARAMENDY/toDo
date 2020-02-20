package fr.eni.ejb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ejb.dal.UtilisateurDAL;

/**
 * Servlet implementation class EraseCompte
 */
@WebServlet("/delCompte")
public class EraseCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean conf = false;
		if (request.getParameter("del") != null) {
			conf = true;
			try {
				UtilisateurDAL.suppAll((int) session.getAttribute("id"));
				if (session != null) {
					session.invalidate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/").forward(request, response);
		}
		if (!conf) getServletContext().getRequestDispatcher("/toDo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
