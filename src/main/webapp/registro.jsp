<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rexistro de Usuario</title>
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
        
        <h1 class="text-center mt-3">Rexistro de Usuario</h1>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <!-- Formulário de registro -->
                        <form action="Registro" method="post">
                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                <input type="text" class="form-control" id="nome" name="nombre" required placeholder="Nome">
                            </div>
                            <div class="form-group">
                                <label for="sobrenome">Apelidos:</label>
                                <input type="text" class="form-control" id="sobrenome" name="apellidos" required placeholder="Apelidos">
                            </div>
                            <div class="form-group">
                                <label for="usuario">Nome de usuario:</label>
                                <input type="text" class="form-control" id="usuario" name="nombreUsuario" required placeholder="Nome de Usuario">
                            </div>
                            <div class="form-group">
                                <label for="senha">Contrasinal:</label>
                                <input type="password" class="form-control" id="senha" name="clave" required placeholder="Contrasinal">
                            </div>
                            <div class="form-group">
                                <label for="confirmaSenha">Confirme o contrasinal:</label>
                                <input type="password" class="form-control" id="confirmaSenha" name="confirmaClave" required placeholder="Confirme o contrasinal"> 
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Rexístrate</button>
                            </div>
                        </form>
                    </div>
                </div>
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
        <p class="text-center">
            <a href="index.jsp" class="nav-link px-2 text-muted">Saír da páxina</a>
        </p>
        <p class="text-center text-muted">&#169; 2023 Ícaro Maltez</p> 
    </footer>
</body>
</html>
