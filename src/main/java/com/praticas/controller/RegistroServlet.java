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
					//request.getSession().setAttribute("usuario", nuevoUsuario);
					response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("error", "Nome ya existe no coiciden");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} 
			} catch (SQLException e) {
				e.printStackTrace();
				
				if(e.getErrorCode() == 1062) {
					request.setAttribute("error", "Las claves no coiciden");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else {
					response.sendRedirect("ErrorInterno.html");
				} 
			}
			
		}else {
			request.setAttribute("error", "Las claves no coiciden");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
		salida.close();
	}

}