<%@page import="com.praticas.model.TipoUsuario"%>
<%@page import="com.praticas.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitude de vacacións</title>
    <!-- Inclua os links para as bibliotecas Bootstrap, jQuery e Bootstrap Datepicker -->
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
               <img id="fotoPrincipal" src="Imagen/imgPrincipal.png" alt="Imagem de Empreza" class="img-fluid">
        
        <h1 class="text-center mt-3">Período no que quere solicitar as súas vacacións</h1>
        
     
       <div style="background-color: #e6f7ff;" class="container text-center mt-5">
    <div class="menu">
        <nav style="background-color: #e6f7ff; margin-bottom: 40px;">
            <ul class="nav justify-content-center">
                <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
                    <% if (usuario.getTipo().equals(TipoUsuario.TRABAJADOR)) { %>
                        <li class="nav-item">
                        <a class="nav-link" href="index2.jsp">Solicitude</a>
                    </li>
                        <li class="nav-item">
                            <a class="nav-link" href="EstadoPeticion.jsp">Estado da solicitude</a>
                        </li>
                    <% } else if (usuario.getTipo().equals(TipoUsuario.GESTOR)) { %>                      
                        <li class="nav-item">
                            <a class="nav-link" href="index2.jsp">Solicitude</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="EstadoPeticion.jsp">Estado de solicitude</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="Peticiones.jsp">Xestionar solicitudes</a>
                        </li>
                    <% } %>
                
            </ul>
        </nav>         
    </div>
</div>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <!-- Formulário para escolher a data usando o Bootstrap Datepicker -->
                        <form action="PeticionVacaciones" method="post">
                            <div class="form-group">
                                <label for="dataInicio">Data de inicio das vacacións:</label>
                                <input type="text" class="form-control datepicker" id="dataInicio" name="FechaInicio" required>
                            </div>
                            <div class="form-group">
                                <label for="dataFim">Data de finalización das vacacións:</label>
                                <input type="text" class="form-control datepicker" id="dataFim" name="FechaFin" required>
                            </div>
                            <div class="form-group">
                                <label for="anoReferencia">Ano de referencia:</label>
                                <select class="form-control" id="anoReferencia" name="anoReferencia">
                                    <option value="2023">2023</option>
                                    <option value="2024">2024</option>
                                    <option value="2025">2025</option>
                                    <!-- Adicione mais anos, se necessário -->
                                </select>
                                
                            </div>
                           <%String mensagen = (String) request.getAttribute("Mensagen"); %>
                            <% if(mensagen != null) { %>
                            <div> <%=mensagen %></div>
                            <% } %>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Solicita vacacións</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Inicialize o Bootstrap Datepicker -->
    <script>
        $(document).ready(function () {
            $('.datepicker').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true
            });
        });
    </script>
    <script type="text/javascript" src="listas.js"></script>
    
       <footer id="final">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
         
            <li class="nav-item"><a href="CerrarSession" class="nav-link px-2 text-muted">Saír da páxina</a></li>
          </ul>
          <p class="text-center text-muted">&#169; 2023 Ícaro Maltez</p> 
    </footer>
</body>
</html>
