package com.praticas.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.praticas.facade.Fachada;
import com.praticas.model.Usuario;
import com.praticas.model.exception.ConexionException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PeticionVacacionesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7258295933608874400L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        if (request.getSession().getAttribute("usuario") != null) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            LocalDate fechaInicio = LocalDate.parse(request.getParameter("FechaInicio"));
            LocalDate fechaFin = LocalDate.parse(request.getParameter("FechaFin"));
            int ano = Integer.parseInt(request.getParameter("anoReferencia"));
            Fachada fachada = new Fachada();           
            
            try {
				fachada.inserirPeticion(usuario, fechaInicio, fechaFin, ano);
			} catch (ConexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
			request.setAttribute("Mensagen", "Peticion de vacaciones insertada correctamente");
			request.getRequestDispatcher("index2.jsp").forward(request, response);

            
        } else {
            response.getWriter().println("Usuário não está logado.");
        }
        
    }
}
