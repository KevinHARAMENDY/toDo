package fr.eni.ejb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ejb.bean.ToDo;
import fr.eni.ejb.dal.UtilisateurDAL;

/**
 * Servlet implementation class Update
 */
@WebServlet("/maj")
public class MAJ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ToDo toDo = null;
		try {
			toDo = UtilisateurDAL.getToDoId(Integer.parseInt(request.getParameter("up")));
			request.setAttribute("up", request.getParameter("up"));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
    	request.setAttribute("actuel", toDo);
    	getServletContext().getRequestDispatcher("/modifToDo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
