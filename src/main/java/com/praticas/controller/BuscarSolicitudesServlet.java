package com.praticas.controller;

	
	import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.praticas.facade.Fachada;
import com.praticas.model.PeticionVacaciones;
import com.praticas.model.exception.ConexionException;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	
	public class BuscarSolicitudesServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String ano = request.getParameter("Ano");
	        String estado = request.getParameter("Estado");
	        String usuario = request.getParameter("Usuario");
	        Fachada fachada = new Fachada();
	        System.out.println(ano);
	        List<PeticionVacaciones> listaSolicitacoes;
			try {
				
				listaSolicitacoes = fachada.buscarSolicitacion(ano, usuario, estado);
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

	