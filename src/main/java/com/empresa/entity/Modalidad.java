package com.empresa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "modalidad")
public class Modalidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModalidad;
	
	private String nombre;
	private String numHombres;
	private String numMujeres;
	private String edadMaxima;
	private String edadMinima;
	private String sede;
	/*Con estas anotaciones es posible emular las llaves foráneas de MySQL*/
	@ManyToOne
	@JoinColumn(name = "idDeporte")
	private Deporte deporte;
}
