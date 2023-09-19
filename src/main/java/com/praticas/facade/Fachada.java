package com.praticas.facade;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.praticas.model.PeticionVacaciones;
import com.praticas.model.Usuario;

import com.praticas.model.dao.SolicitudeJDBCDAO;
import com.praticas.model.dao.UsuarioJDBCDAO;
import com.praticas.model.exception.ConexionException;

public class Fachada {
	 
	public Usuario iniciarSesion(String nombreUsuario, String clave) throws ConexionException {
		UsuarioJDBCDAO dao = new UsuarioJDBCDAO();
		Usuario usuario;
		try {
			usuario = dao.buscarUsuarioPorNombreUsuario(nombreUsuario);
			if (usuario != null && usuario.getClave().equals(clave)) {
				return usuario;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("No hay conexión con los datos");
		}
	}
	
	
	
	public boolean resgistrarUsuario(Usuario nuevoUsuario ) throws SQLException {
		UsuarioJDBCDAO dao = new UsuarioJDBCDAO();
		return dao.insertarUsuario(nuevoUsuario);
	
	}
	

	public List<PeticionVacaciones> buscarSolicitacion(String ano , String usuario, String estado) throws ConexionException {
		SolicitudeJDBCDAO dao = new SolicitudeJDBCDAO();
		try {
			return dao.buscarSolicitacoes(ano, usuario, estado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("No hay conexión con los datos");
		}	
	}
	
	
	    public void inserirPeticion(Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin, int ano) throws ConexionException {
	    	SolicitudeJDBCDAO dao = new SolicitudeJDBCDAO();
	    	try {
	        dao.inserirPeticion(usuario, fechaInicio, fechaFin, ano);
	        
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ConexionException("No hay conexión con los datos");
			}	
		}
	    
	    
	    
	    public boolean atualizarEstado(int idPeticion, String estado) throws ConexionException {
	    	SolicitudeJDBCDAO dao = new SolicitudeJDBCDAO();
	    	try {
				return dao.atualizarPeticion(idPeticion, estado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ConexionException("No hay conexión con los datos");
			}
	    }
	    
	    
	 }

	



