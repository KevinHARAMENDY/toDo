package fr.eni.ejb.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.ejb.bean.ToDo;
import fr.eni.ejb.bean.Utilisateur;

public class UtilisateurDAL {
	static Connection cnx = null;
	static PreparedStatement rqt = null;
	static ResultSet rs = null;
	
	public static void connexion() {
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String url = "jdbc:sqlserver://localhost;databasename=EJB";
			cnx = DriverManager.getConnection(url, "my_sql_user","FairyTail17");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deconnexion() {
		try {
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Utilisateur> getUsers() throws SQLException{
		connexion();
		ArrayList<Utilisateur> liste = new ArrayList<>();
		try {
			rqt = cnx.prepareStatement("select * from utilisateurs");
			rs=rqt.executeQuery();
			while (rs.next()){
				Utilisateur user = new Utilisateur(rs.getInt("id"),rs.getString("nom"),rs.getString("mdp"));
				liste.add(user);
			}
		} finally {
			deconnexion();
		}
		return liste;
	}
	
	public static Utilisateur getUser(int id) throws SQLException {
		connexion();
		Utilisateur user = null;
		try {
			rqt = cnx.prepareStatement("select * from utilisateurs where id=?");
			rqt.setInt(1, id);
			rs=rqt.executeQuery();
			if (rs.next()){
				user = new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("mdp"));
			}
		} finally {
			deconnexion();
		}
		return user;
	}
	
	public static void addUser(String nom, String mdp) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("insert into utilisateurs (nom,mdp) values (?,?)");
			rqt.setString(1, nom);
			rqt.setString(2, mdp);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}
	
	public static void upNomUser(String nom, int id) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("update utilisateurs set nom=? where id=?");
			rqt.setString(1, nom);
			rqt.setInt(2, id);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}
	
	public static void upMdpUser(String mdp, int id) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("update utilisateurs set mdp=? where id=?");
			rqt.setString(1, mdp);
			rqt.setInt(2, id);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}
	
	public static ArrayList<ToDo> getToDo(int idUser) throws SQLException {
		connexion();
		ArrayList<ToDo> liste = new ArrayList<>();
		try {
			rqt = cnx.prepareStatement("select * from toDo where idUser=?");
			rqt.setInt(1, idUser);
			rs=rqt.executeQuery();
			while (rs.next()){
				ToDo toDo = new ToDo(rs.getInt("id"),rs.getString("libelle"),rs.getInt("idUser"));
				liste.add(toDo);
			}
		} finally {
			deconnexion();
		}
		return liste;
	}
	
	public static ToDo getToDoId(int id) throws SQLException {
		connexion();
		ToDo todo = new ToDo();
		try {
			rqt = cnx.prepareStatement("select * from toDo where id=?");
			rqt.setInt(1, id);
			rs=rqt.executeQuery();
			if (rs.next()){
				ToDo toDo = new ToDo(rs.getInt("id"),rs.getString("libelle"),rs.getInt("idUser"));
				todo = toDo;
			}
		} finally {
			deconnexion();
		}
		return todo;
	}
	
	public static void addToDo(String libelle, int id) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("insert into toDo (libelle,idUser) values (?,?)");
			rqt.setString(1, libelle);
			rqt.setInt(2, id);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}
	
	public static void delToDo(int id) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("delete from toDo where id=?");
			rqt.setInt(1, id);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}
	
	public static void upToDo(String libelle, int id) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("update toDo set libelle=? where id=?");
			rqt.setString(1, libelle);
			rqt.setInt(2, id);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}

	public static void suppAll(int id) throws SQLException {
		connexion();
		try {
			rqt = cnx.prepareStatement("delete from toDo where idUser=?;delete from utilisateurs where id=?");
			rqt.setInt(1, id);
			rqt.setInt(2, id);
			rqt.executeUpdate();
		} finally {
			deconnexion();
		}
	}
	
}
