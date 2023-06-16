package com.fabien.spring.jpa.h2.model;
import javax.persistence.*;

@Entity
@Table(name = "tarifs")
public class Tarifs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "taxe_atterrissage")
	private String taxeAtterrissage;

	@Column(name = "taxe_parking")
	private String taxeParking;

	@Column(name = "carburant")
	private String carburant;

	@OneToOne
	@JoinColumn(name = "aeroclub_fk")
	private AeroClub aeroClub;


	public Tarifs() {

	}

	public Tarifs(long id, String taxeAtterrissage, String taxeParking, String carburant, AeroClub aeroClub) {
		this.id = id;
		this.taxeAtterrissage = taxeAtterrissage;
		this.taxeParking = taxeParking;
		this.carburant = carburant;
		this.aeroClub = aeroClub;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaxeAtterrissage() {
		return taxeAtterrissage;
	}

	public void setTaxeAtterrissage(String taxeAtterrissage) {
		this.taxeAtterrissage = taxeAtterrissage;
	}

	public String getTaxeParking() {
		return taxeParking;
	}

	public void setTaxeParking(String taxeParking) {
		this.taxeParking = taxeParking;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public AeroClub getAeroClub() {
		return aeroClub;
	}

	public void setAeroClub(AeroClub aeroClub) {
		this.aeroClub = aeroClub;
	}

	@Override
	public String toString() {
		return "Tarifs{" +
				"id=" + id +
				", taxeAtterrissage='" + taxeAtterrissage + '\'' +
				", taxeParking='" + taxeParking + '\'' +
				", carburant='" + carburant + '\'' +
				", aeroClub=" + aeroClub +
				'}';
	}
}
