package it.corso.service;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService
{   
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public boolean userLogin(String username, String password, HttpSession session)
	{
			if(userDao.findByUsernameAndPassword(username, password) != null)	
			{
				session.setAttribute("log", true);
				return true;
			}
		
		return false;
	}

	@Override
	public User getUserById(int id) {
		
		return userDao.findById(id).get();
	}
}