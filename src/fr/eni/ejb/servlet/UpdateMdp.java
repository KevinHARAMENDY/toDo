package fr.eni.ejb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ejb.bean.Utilisateur;
import fr.eni.ejb.dal.UtilisateurDAL;

/**
 * Servlet implementation class UpdateMdp
 */
@WebServlet("/updateMdp")
public class UpdateMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mdp;
    	if (request.getParameter("save") != null) {
			try {
				UtilisateurDAL.upMdpUser(request.getParameter("newMdp"), (int) session.getAttribute("id"));
				Utilisateur user = UtilisateurDAL.getUser((int) session.getAttribute("id"));
				mdp = user.getMdp();
				session.setAttribute("mdp", mdp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/toDo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
