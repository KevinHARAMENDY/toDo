package fr.eni.ejb.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.ejb.dal.UtilisateurDAL;

@SuppressWarnings("serial")
public class Utilisateur implements Serializable {
	private int id;
	private String login, mdp;
	private ArrayList<ToDo> toDo;
	
	public Utilisateur() {}
	
	public Utilisateur(int id, String login, String mdp) {
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public ArrayList<ToDo> getToDo() {
		try {
			toDo = UtilisateurDAL.getToDo(this.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toDo;
	}
}
