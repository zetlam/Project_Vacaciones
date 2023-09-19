package com.praticas.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.praticas.model.EstadoPeticion;
import com.praticas.model.PeticionVacaciones;
import com.praticas.model.Usuario;

public class SolicitudeJDBCDAO {
   
    

    public List<PeticionVacaciones> buscarSolicitacoes(String ano, String usuario, String estado) throws SQLException {
        List<PeticionVacaciones> listaSolicitacoes = new ArrayList<>();

        Connection conexion = DaoUtility.getConnection();
         String sql = "SELECT P.idPeticion AS ID, U.nombre AS NombreUsuario, P.fechaInicio AS FechaInicio, P.fechaFin AS FechaFin, P.estado AS Estado FROM PeticionVacaciones AS P INNER JOIN Usuarios AS U ON P.realiza = U.id where año LIKE ? and estado LIKE ? and U.NombreUsuario LIKE ?";
         
         PreparedStatement stmt = conexion.prepareStatement(sql);
         if(ano == null || ano.equals("")) {
		stmt.setString(1, "%");
         } else {
		stmt.setString(1, ano);
         }
         if(usuario == null || usuario.equals("")) {
		 stmt.setString(3, "%");
         } else {
		stmt.setString(3, usuario);
         }
         if(estado == null || estado.equals("")) {
		 stmt.setString(2, "%");
         } else {
		stmt.setString(2, estado);
         }
         System.out.println(stmt);
         ResultSet rs = stmt.executeQuery();
         while (rs.next()) {
		int id = rs.getInt("id");
		LocalDate fechaInicio = rs.getDate("FechaInicio").toLocalDate();
		LocalDate fechaTermino = rs.getDate("FechaFin").toLocalDate();
		String estadoSolicitud = rs.getNString("Estado");
		String nombreUsuario = rs.getString("NombreUsuario");
		Usuario usuarioNuevo = new Usuario(0, nombreUsuario, nombreUsuario, "", "", null);
		PeticionVacaciones solicitud = new PeticionVacaciones(id, fechaInicio, fechaTermino, EstadoPeticion.valueOf(estadoSolicitud), usuarioNuevo);
		listaSolicitacoes.add(solicitud);
         }
         
         rs.close();
         stmt.close();
         conexion.close();

        return listaSolicitacoes;
    }
    
    public void inserirPeticion (Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin, int ano) throws SQLException {
        Connection conexion = DaoUtility.getConnection();
        String sql = "INSERT INTO PeticionVacaciones (fechaInicio, fechaFin, estado, comentario, año, realiza) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);

        try {
            
        		sentencia.setDate(1, Date.valueOf(fechaInicio));
        		sentencia.setDate(2, Date.valueOf(fechaFin));
            sentencia.setString(3, EstadoPeticion.PENDIENTE.name());
            sentencia.setString(4, "");
            sentencia.setInt(5, ano);
            sentencia.setInt(6, usuario.getId());

            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                	sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    public boolean atualizarPeticion(int idPeticion, String estado) throws SQLException {
    		Connection conexion = DaoUtility.getConnection();
            String sql = "UPDATE PeticionVacaciones SET estado = ? WHERE idPeticion = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            
             try { 
            	 sentencia.setString(1, estado);
            	 sentencia.setInt(2, idPeticion);
            	 System.out.println(sentencia);
            int rowsUpdated = sentencia.executeUpdate();
            
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
    
    
    
}
