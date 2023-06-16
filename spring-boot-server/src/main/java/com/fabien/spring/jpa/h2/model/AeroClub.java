package com.fabien.spring.jpa.h2.model;
import javax.persistence.*;

@Entity
@Table(name = "aeroclub")
public class AeroClub {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "oaci")
	private String oaci;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "mail")
	private String mail;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "codePostal")
	private String codePostal;


	public AeroClub() {

	}

	public AeroClub(long id, String oaci, String name, String type, String phoneNumber, String mail, String adresse, String codePostal) {
		this.id = id;
		this.oaci = oaci;
		this.name = name;
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.adresse = adresse;
		this.codePostal = codePostal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOaci() {
		return oaci;
	}

	public void setOaci(String oaci) {
		this.oaci = oaci;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "AeroClub{" +
				"id=" + id +
				", oaci='" + oaci + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", mail='" + mail + '\'' +
				", adresse='" + adresse + '\'' +
				", codePostal='" + codePostal + '\'' +
				'}';
	}
}
