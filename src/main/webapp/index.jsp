<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceder</title>
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
        <img id="fotoLogin" src="Imagen/imgPrincipal.png" alt="Imagem de Empreza" class="img-fluid">
        
        <h1 class="text-center mt-3">Acceder</h1>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <!-- Formulário de login -->
                        <form action="inicioSession" method="post">
                            <div class="form-group">
                                <label for="usuario">Nome de usuario:</label>
                                <input type="text" class="form-control" id="usuario" name="usuario" required>
                            </div>
                            <div class="form-group">
                                <label for="senha">Contrasinal:</label>
                                <input type="password" class="form-control" id="senha" name="clave" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Acceder</button>
                            </div>
                            
                            <% String error = (String)request.getAttribute("error"); %> 
                            <% if(error != null){%>
                            <div><%=error%></div>
                            <%} %>
                            
                        </form>
                    </div>
                </div>
                <p class="text-center mt-3">
                    <a href="registro.jsp">Rexistrar un novo usuario</a> | 
                    <a href="recuperar_senha.jsp">Recuperar contrasinal</a>
                </p>
            </div>
        </div>
    </div>

    
    <script>
        $(document).ready(function () {
            $('.datepicker').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true
            });
        });
    </script>
    
    <footer id="final">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="https://www.informateoposiciones.es" class="nav-link px-2 text-muted">Páxina de inicio</a></li>
            <li class="nav-item"><a href="index.jsp" class="nav-link px-2 text-muted">Saír da páxina</a></li>
        </ul>
        <p class="text-center text-muted">&#169; 2023 Ícaro Maltez</p> 
    </footer>
</body>
</html>
