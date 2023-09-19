package com.praticas.model;

import java.time.LocalDate;
import java.util.Objects;

public class PeticionVacaciones {
	private int idPeticion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int ano;
    private String comentario;
    private EstadoPeticion estado;
    private Usuario usuario;
    
    public PeticionVacaciones(int idPeticion, LocalDate fechaInicio, LocalDate fechaFin, int ano, String comentario, EstadoPeticion estado, Usuario usuario) {
        this.idPeticion = idPeticion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ano = ano;
        this.comentario = comentario;
        this.estado = estado;
        this.usuario = usuario;
    }
    

	public PeticionVacaciones(int idPeticion, LocalDate fechaInicio, LocalDate fechaFin, EstadoPeticion estado,
			Usuario usuario) {
		super();
		this.idPeticion = idPeticion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.usuario = usuario;
	}


	public PeticionVacaciones() {
		super();
	}


	public int getIdPeticion() {
		return idPeticion;
	}

	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public EstadoPeticion getEstado() {
		return estado;
	}

	public void setEstado(EstadoPeticion estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "idPeticio: " + idPeticion + ", fechaInicio: " + fechaInicio + ", fechaFin: "
				+ fechaFin + ", año: " + ano + ", comentario: " + comentario + ", estado: " + estado + ", usuario: "
				+ usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPeticion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeticionVacaciones other = (PeticionVacaciones) obj;
		return idPeticion == other.idPeticion;
	}
	
	
	
    

}
