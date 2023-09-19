package com.praticas.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.praticas.facade.Fachada;
import com.praticas.model.PeticionVacaciones;
import com.praticas.model.Usuario;
import com.praticas.model.exception.ConexionException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EstadoPeticionServlet
 */
public class EstadoPeticionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ano = request.getParameter("Ano");
        String estado = request.getParameter("Estado");
        Fachada fachada = new Fachada();
        List<PeticionVacaciones> listaSolicitacoes;
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			System.out.println(ano + " " + usuario + " " + estado);
			listaSolicitacoes = fachada.buscarSolicitacion(ano, usuario.getNombreUsuario(), estado);
	        response.setContentType("application/json");

	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule()); 
	        String json = objectMapper.writeValueAsString(listaSolicitacoes);
	        System.out.println(json);
	        response.getWriter().write(json);
		} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
