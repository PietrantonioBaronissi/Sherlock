package it.corso.service;
import javax.servlet.http.HttpSession;
import it.corso.model.User;

public interface UserService
{
	
	boolean userLogin(String username, String password, HttpSession session);
	User getUserById(int id);
}