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
        


		
        
            </div>
             <% String error = (String)request.getAttribute("error"); %> 
                            <% if(error != null){%>
                            <div><%=error%></div>
                            <%} %>
       

        <!-- Tabela de solicitações de férias -->
        <table class="table table-striped" id="solicitacoesTable">
            
            </table>
            <div id="listaSolicitudesDiv"></div>
           
                       
        <p class="text-center">
            <a href="index2.sp">Volver á páxina principal</a>
        </p>
    </div>
    <footer class="text-center">
        <p>&#169; 2023 Ícaro Maltez</p>
    </footer>
    <script type="text/javascript" src="listas.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</body>
</html>
