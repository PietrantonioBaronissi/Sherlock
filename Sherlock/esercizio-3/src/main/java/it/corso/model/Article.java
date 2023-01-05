package it.corso.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "opere")
public class Article implements Serializable
{
	private static final long serialVersionUID = 5487533939965844137L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_opera;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "titolo", length = 255, nullable = false)
	private String titolo;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "descrizione", length = 255, nullable = false)
	private String descrizione;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "tipologia", length = 255, nullable = false)
	private String tipologia;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,10000}", message = "{error.charnotallowed}")
	@Column(name = "informazioni", length = 10000, nullable = false)
	private String informazioni;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,10000}", message = "{error.charnotallowed}")
	@Column(name = "dettagli", length = 255, nullable = false)
	private String dettagli;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,255}", message = "{error.charnotallowed}")
	@Column(name = "luoghi", length = 255, nullable = false)
	private String luoghi;
	
	@Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\s]{1,10000}", message = "{error.charnotallowed}")
	@Column(name = "trama", length = 255, nullable = false)
	private String trama;
	
	
	
	public String getTrama() {
		return trama;
	}


	public void setTrama(String trama) {
		this.trama = trama;
	}


	public String getInformazioni() {
		return informazioni;
	}


	public void setInformazioni(String informazioni) {
		this.informazioni = informazioni;
	}


	public String getDettagli() {
		return dettagli;
	}


	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}


	public String getLuoghi() {
		return luoghi;
	}


	public void setLuoghi(String luoghi) {
		this.luoghi = luoghi;
	}
	@Transient
	private boolean included;
	
	@Transient
	private boolean image;
		
	public int getId()
	{
		return id_opera;
	}
	
	
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getTipologia() {
		return tipologia;
	}


	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setId(int id) {
		this.id_opera = id;
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