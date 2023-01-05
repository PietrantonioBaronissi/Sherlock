package it.corso.model;
import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




import javax.persistence.Table;
import javax.persistence.Transient;

import javax.validation.constraints.Pattern;



@Entity
@Table(name = "opere")
public class Opera implements Serializable
{
	private static final long serialVersionUID = 5487533939965844137L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Pattern(regexp = "[a-zA-Z0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "titolo", length = 255, nullable = false)
	private String titolo;
	
	@Pattern(regexp = "[a-zA-Z0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "descrizione", nullable = false)
	private String descrizione;
	
	@Pattern(regexp = "[a-zA-Z0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "tipologia",nullable = false)
	private String tipologia;
	
	
	
	
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	@Transient
	private boolean included;
	
	@Transient
	private boolean image;
		
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitolo()
	{
		return titolo;
	}
	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}
	public String getDescrizione()
	{
		return descrizione;
	}
	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}
	
	public boolean isIncluded()
	{
		return included;
	}
	public void setIncluded(boolean included)
	{
		this.included = included;
	}
	public boolean isImage()
	{
		return image;
	}
	public void setImage(boolean image)
	{
		this.image = image;
	}
}