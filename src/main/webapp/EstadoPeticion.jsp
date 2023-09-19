<%@page import="com.praticas.model.TipoUsuario"%>
<%@page import="com.praticas.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Solicitações de Férias</title>
    <link rel="stylesheet" href="Vacaciones.css" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <!-- Imagem acima do formulário -->
        <img id="fotoLogin" src="Imagen/imgPrincipal.png" alt="Imagem de Empreza" class="img-fluid">
        
        <h1 class="text-center mt-3">Lista de solicitudes de vacaciones</h1>

		<div style="background-color: #e6f7ff;" class="container text-center mt-5">
    <div class="menu">
        <nav style="background-color: #e6f7ff; margin-bottom: 40px;">
            <ul class="nav justify-content-center">
                <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
                    <% if (usuario.getTipo().equals(TipoUsuario.TRABAJADOR)) { %>
                        <li class="nav-item">
                        <a class="nav-link" href="index2.jsp">Solicitar</a>
                    </li>
                        <li class="nav-item">
                            <a class="nav-link" href="EstadoPeticion.jsp">Estado de solicitud</a>
                        </li>
                    <% } else if (usuario.getTipo().equals(TipoUsuario.GESTOR)) { %>                      
                        <li class="nav-item">
                            <a class="nav-link" href="index2.jsp">Solicitar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="EstadoPeticion.jsp">Estado de solicitud</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="Peticiones.jsp">Gestionar Solicitudes</a>
                        </li>
                    <% } %>
                
            </ul>
        </nav>
    </div>
</div>
		
        <!-- Formulário de pesquisa -->
 <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="buscarSolicitacoes" method="get">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="ano">Ano:</label>
                        <input type="text" class="form-control" id="ano" name="ano">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="estado">Estado:</label>
                        <select class="form-control" id="estado" name="estado">
                            <option value="">Seleccione o estado</option>
                            <option value="ACEPTADA">Aprobado</option>
                            <option value="PENDIENTE">Pendente</option>
                            <option value="RECHAZADA">Rexeitado</option>
                        </select>
                    </div>
                </div>
                <div class="form-group text-center">
                    <button type="button" class="btn btn-primary" onclick="buscarSolicitacionesTrabajador();">Buscar</button>
                </div>
            </form>
        </div>
    </div>
</div>

        <!-- Tabela de solicitações de férias -->
        <table class="table table-striped" id="solicitacoesTable">
            
            </table>
            <div id="listaSolicitudesDiv"></div>
           
                       
        <p class="text-center">

            <a href="index.jsp" class="nav-link px-2 text-muted">Saír da páxina</a>
        </p>
    </div>
    <footer class="text-center">
        <p>&#169; 2023 Ícaro Maltez</p>
    </footer>
    <script type="text/javascript" src="listaTrabajador.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</body>
</html>