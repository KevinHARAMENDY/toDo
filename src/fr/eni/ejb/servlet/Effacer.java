package fr.eni.ejb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ejb.bean.Utilisateur;
import fr.eni.ejb.dal.UtilisateurDAL;
import fr.eni.ejb.bean.ToDo;

/**
 * Servlet implementation class Effacer
 */
@WebServlet("/effacer")
public class Effacer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<ToDo> listeToDo = new ArrayList<ToDo>();
    	try {
			UtilisateurDAL.delToDo(Integer.parseInt(request.getParameter("er")));
			Utilisateur user = UtilisateurDAL.getUser((int) session.getAttribute("id"));
			listeToDo = user.getToDo();
			session.setAttribute("toDo", listeToDo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/toDo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
