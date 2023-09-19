package com.praticas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.praticas.model.TipoUsuario;
import com.praticas.model.Usuario;

public class UsuarioJDBCDAO {
	
	private final static String BUSCAR_POR_NOMBRE_USUARIO = "select * from Usuarios where nombreUsuario = ?";

	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) throws SQLException {
		Usuario usuario = null;
		Connection conexion = DaoUtility.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement(BUSCAR_POR_NOMBRE_USUARIO);
		sentencia.setString(1, nombreUsuario);
		ResultSet resultado = sentencia.executeQuery();
		if (resultado.next()) {
			int idUsuario = resultado.getInt("id");
			String nombre = resultado.getString("nombre");
			String apellidos = resultado.getString("apellidos");
			String clave = resultado.getString("clave");
			TipoUsuario tipo = TipoUsuario.valueOf(resultado.getString("tipoUsuario"));
			usuario = new Usuario(idUsuario, nombreUsuario, nombre, clave, apellidos, tipo);
		}
		conexion.close();
		return usuario;
	}
	
	public boolean insertarUsuario(Usuario nuevoUsuario) throws SQLException {
		boolean insertado = false;
		Connection conexion = DaoUtility.getConnection();
		PreparedStatement sentencia = conexion.prepareStatement("insert into Usuarios(nombre, apellidos, nombreUsuario, clave, tipoUsuario) values(?, ?, ?, ?, ?);");                                                                 
		sentencia.setString(1, nuevoUsuario.getNombre());
		sentencia.setString(2, nuevoUsuario.getApellidos());
		sentencia.setString(3, nuevoUsuario.getNombreUsuario());
		sentencia.setString(4, nuevoUsuario.getClave());
		sentencia.setString(5,TipoUsuario.TRABAJADOR.name());
		int numFilas = sentencia.executeUpdate();
		if(numFilas == 1) {
			insertado = true;
		}
		conexion.close();
		return insertado;
		
	}
	
}
