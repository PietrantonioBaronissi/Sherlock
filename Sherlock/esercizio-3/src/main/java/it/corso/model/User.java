package it.corso.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "anagrafica")
public class User implements Serializable
{
	private static final long serialVersionUID = -4243983799375604945L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_anagrafica;
	
	
	
	public int getId_anagrafica() {
		return id_anagrafica;
	}

	public void setId_anagrafica(int id_anagrafica) {
		this.id_anagrafica = id_anagrafica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String username;
	
	private String password;

	

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	
}