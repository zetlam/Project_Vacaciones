package com.praticas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.praticas.facade.Fachada;
import com.praticas.model.TipoUsuario;
import com.praticas.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");
		String claveR = request.getParameter("confirmaClave");
		PrintWriter salida = response.getWriter();
		response.setContentType(claveR);
				
		if(clave.equals(claveR)) {
			Usuario nuevoUsuario = new Usuario(0, nombreUsuario, nombre, clave, apellidos, TipoUsuario.TRABAJADOR);
			
			Fachada f = new Fachada();
			boolean registrado;
			try {
				registrado = f.resgistrarUsuario(nuevoUsuario);
				if(registrado) {
					response.sendRedirect("index2.jsp");
			} else {
				salida.write("<html><head></head><body>EL NOMBRE YA EXISTE</body></html>");
			} 
			} catch (SQLException e) {
				e.printStackTrace();
				
				if(e.getErrorCode() == 1062) {
					salida.write("<html><head></head><body>EL NOMBRE YA EXISTE</body></html>");
				} else {
					response.sendRedirect("ErrorInterno.html");
				} 
			}
			
		}else {
			salida.write("<html><head></head><body>Las claves son iguales</body></html>");
			
		}
		salida.close();
	}

}