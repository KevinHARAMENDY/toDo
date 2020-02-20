package fr.eni.ejb.ejb;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import fr.eni.ejb.bean.Utilisateur;

@Stateless
public class EjbCnx {
	
	public static boolean verifCnx(HttpServletRequest request, Utilisateur user) {
		if (user.getLogin().equals(request.getParameter("nom")) && user.getMdp().equals(request.getParameter("mdp"))) {
			return true;
		}
		return false;
	}
	
}