package com.praticas.controller;
import java.io.IOException;

import com.praticas.facade.Fachada;
import com.praticas.model.exception.ConexionException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RespuestaPeticionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPeticionTxt = request.getParameter("idPeticion");
        String estado = request.getParameter("estado");

        if (idPeticionTxt != null && estado != null) {
        	int idPeticion = Integer.parseInt(idPeticionTxt);
          Fachada fachada = new Fachada();
            try {
                boolean atualizado = fachada.atualizarEstado(idPeticion, estado);

                if (atualizado) {
                    
                    response.sendRedirect("Peticiones.jsp");
                } else {
                  
                	response.sendRedirect("Peticiones.jsp");
                }
            } catch (ConexionException e) {
                e.printStackTrace();
               request.setAttribute("error", "No hay conexion con los datos");
               request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            response.getWriter().write("Parámetros non válidos");
        }
    }
}
