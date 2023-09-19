package com.praticas.controller;


import java.io.IOException;

import com.praticas.facade.Fachada;
import com.praticas.model.Usuario;
import com.praticas.model.exception.ConexionException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IniciarSesionServlet
 */
public class InicioSessionServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7258295933608874400L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreUsuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		Fachada fachada = new Fachada();
		try {
			Usuario usuario = fachada.iniciarSesion(nombreUsuario, clave);
			if (usuario != null) {
				request.getSession().setAttribute("usuario", usuario);
			
				        response.sendRedirect("index2.jsp");
				
			} else {
				request.setAttribute("error", "Datos no encontrados. SI es nuevo, registrese");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	

}}